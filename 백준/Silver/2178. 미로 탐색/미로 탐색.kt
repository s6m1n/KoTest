import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    val N = input[0] // y
    val M = input[1] // x
    val array: Array<IntArray> = Array(N) { intArrayOf() }
    repeat(N) { idx ->
        array[idx] = br.readLine().map { it.digitToInt() }.toIntArray() // digitToInt
    }
    val queue: Queue<IntArray> = LinkedList()
    val visited: Array<BooleanArray> = Array(N) { BooleanArray(M) { false } }
    queue.add(intArrayOf(0, 0, 1))
    visited[0][0] = true // 방문 처리

    val dy = intArrayOf(1, -1, 0, 0)
    val dx = intArrayOf(0, 0, 1, -1)

    while (queue.isNotEmpty()) {
        val (y, x, cnt) = queue.poll() // 큐에서 뽑아와
        if (y == N - 1 && x == M - 1) { // 종점 도착
            println(cnt)
            break
        }
        for (i in 0..3) {
            val newY = y + dy[i]
            val newX = x + dx[i]

            if (newY in 0 until N && newX in 0 until M) {
                if (array[newY][newX] == 1 && !visited[newY][newX]) { // until
                    queue.add(intArrayOf(newY, newX, cnt + 1))
                    visited[newY][newX] = true // 큐에 추가하고 방문처리
                }
            }
        }
    }
}
