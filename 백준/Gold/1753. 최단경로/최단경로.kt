import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val INF = Int.MAX_VALUE
    val (V, E) = readLine().split(" ").map { it.toInt() } // 정점 수 <= 20,000 / 간선 수 <= 300,000
    val start = readLine().toInt() // 시작 번호
    val graph = Array(V + 1) { mutableListOf<IntArray>() }
    repeat(E) {
        val (S, E, W) = readLine().split(" ").map { it.toInt() }
        graph[S].add(intArrayOf(E, W))
    }
    val visit = BooleanArray(V + 1) { false }.apply { this[start] = true }
    val result = IntArray(V + 1) { INF }.apply { this[start] = 0 }

    val pq = PriorityQueue<IntArray>(compareBy { it[1] }) // 노드, 거리 쌍
    pq.add(intArrayOf(start, 0))

    while (pq.isNotEmpty()) {
        val (start, distance) = pq.poll() // 시작점, 시작점까지 오는데 걸린 거리
        visit[start] = true
        for ((next, weight) in graph[start]) { // 시작점과 연결된 점, 연결된 점까지 가는 거리
            if (!visit[next] && distance + weight < result[next]) { // 최단 거리 찾았으면 갱신
                result[next] = distance + weight
                pq.add(intArrayOf(next, distance + weight))
            }
        }
    }
    println(result.drop(1).joinToString("\n") { if (it == INF) "INF" else it.toString() })
}
