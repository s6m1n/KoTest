import java.util.*

lateinit var graph: Array<MutableList<IntArray>>
fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, X) = readLine().split(" ").map { it.toInt() }
    val answers = IntArray(N + 1)
    graph = Array(N + 1) { mutableListOf() }
    repeat(M) {
        val (start, end, weight) = readLine().split(" ").map { it.toInt() }
        graph[start] += intArrayOf(end, weight)
    }
    for (n in 1..N) {
        if (n == X) continue
        answers[n] = (dijkstra(X, n, N) + dijkstra(n, X, N))
    }
    println(answers.max())
}

fun dijkstra(start: Int, end: Int, N:Int): Int {
    val dijArr = IntArray(N + 1) { Int.MAX_VALUE }
    dijArr[start] = 0
    val pq = PriorityQueue<IntArray>(compareBy { it[1] })
    pq.add(intArrayOf(start, 0))

    while (pq.isNotEmpty()) {
        val (stopover, distance) = pq.poll()
        for ((node, weight) in graph[stopover]) {
            if (distance + weight < dijArr[node]) {
                dijArr[node] = distance + weight
                pq.add(intArrayOf(node, distance + weight))
            }
        }
    }
    return dijArr[end]
}