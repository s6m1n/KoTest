import java.util.*

var N = 0
fun main() = with(System.`in`.bufferedReader()) {
    var cnt = 1
    while (true) {
        N = readLine().toInt()
        if (N == 0) break
        val array = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        val answer = Array(N) { IntArray(N) { Int.MAX_VALUE } }
        val visited = Array(N) { BooleanArray(N) { false } }
        println("Problem ${cnt}: ${dijkstra(array, answer, visited)}")
        cnt++
    }
}


fun dijkstra(array: Array<IntArray>, answer: Array<IntArray>, visited: Array<BooleanArray>) : Int {
    val pq = PriorityQueue<IntArray>(compareBy { it[2] })
    val y = 0
    val x = 0
    val start = array[y][x]
    answer[0][0] = start
    pq.add(intArrayOf(y, x, start))
    while (pq.isNotEmpty()) {
        val (y, x, sum) = pq.poll()
        visited[y][x] = true
        if (sum < answer[y][x]) answer[y][x] = sum
        if (y < N - 1 && !visited[y + 1][x]) {
            pq.add(intArrayOf(y + 1, x, sum + array[y + 1][x]))
        }
        if (x < N - 1 && !visited[y][x + 1]) {
            pq.add(intArrayOf(y, x + 1, sum + array[y][x + 1]))
        }
        if (0 < y && !visited[y - 1][x]) {
            pq.add(intArrayOf(y - 1, x, sum + array[y - 1][x]))
        }
        if (0 < x && !visited[y][x - 1]) {
            pq.add(intArrayOf(y, x - 1, sum + array[y][x - 1]))
        }
    }
    return answer[N - 1][N - 1]
}
