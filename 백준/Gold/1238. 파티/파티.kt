import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, X) = readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<IntArray>() }
    val reversedGraph = Array(N + 1) { mutableListOf<IntArray>() }
    repeat(M) {
        val (start, end, weight) = readLine().split(" ").map { it.toInt() }
        graph[start] += intArrayOf(end, weight)
        reversedGraph[end] += intArrayOf(start, weight)
    }
    val arr = dijkstra(X, N, graph)
    val reversedArr = dijkstra(X, N, reversedGraph)
    var max = 0
    for (n in 1..N) {
        if (max < arr[n] + reversedArr[n]) max = arr[n] + reversedArr[n]
    }
    println(max)
}

fun dijkstra(start: Int, N: Int, graph: Array<MutableList<IntArray>>): IntArray {
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
    return dijArr
}