import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val INF = Int.MAX_VALUE
    val (N, M) = readLine().split(" ").map { it.toInt() } // N : 노드 수, M : 간선 수
    val graph = Array(N + 1) { mutableListOf<IntArray>() }
    repeat(M) {
        val (start, end, weight) = readLine().split(" ").map { it.toInt() }
        graph[start].add(intArrayOf(end, weight))
        graph[end].add(intArrayOf(start, weight))
    }
    val pq = PriorityQueue<IntArray>(compareBy { it[1] }) //
    val result = IntArray(N + 1) { INF }.apply { this[1] = 0 }
    val visited = BooleanArray(N + 1) { false }
    pq.add(intArrayOf(1, 0))
    while (pq.isNotEmpty()) { // 큐가 비어있지 않을 동안 반복
        val (newStart, weightSum) = pq.poll() // 시작점, 지금까지 준 여물 총합
        visited[newStart] = true // 방문 처리
        for (linkedNode in graph[newStart]) { // 시작점과 이어진 모든 점 검사
            val (nextNode, weight) = linkedNode // 0 : 다음 점, 1 : 줘야하는 여물
            if (!visited[nextNode] && weightSum + weight < result[nextNode]) {
                result[nextNode] = weightSum + weight
                pq.add(intArrayOf(nextNode, weightSum + weight))
            }
        }
    }
    println(result.last())
}
