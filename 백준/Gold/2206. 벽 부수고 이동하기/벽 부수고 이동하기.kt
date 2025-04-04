import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0 // y
var M = 0 // x
val direction = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    N = n
    M = m
    val map = Array(N) { IntArray(M) }
    val visited = Array(N) { Array(M) { BooleanArray(2) } }
    repeat(N) {
        map[it] = readln().map { it.digitToInt() }.toIntArray()
    }
    val queue = LinkedList<IntArray>()
    var answer = Int.MAX_VALUE
    queue.add(intArrayOf(0, 0, 1, 0))
    visited[0][0][0] = true
    visited[0][0][1] = true
    while (queue.isNotEmpty()) {
        val (y, x, cnt, brokenCnt) = queue.pop()
        if (y == N - 1 && x == M - 1) {
            answer = min(cnt, answer)
        }
        direction.forEach { (dy, dx) -> // 네 방향 다 확인
            val newY = y + dy
            val newX = x + dx
            if (newY in 0 until N && newX in 0 until M) { // 갈 수 있는 곳일 때
                if (brokenCnt == 0) { // 안 부숨
                    if (map[newY][newX] == 0 && visited[newY][newX][0].not()) {
                        visited[newY][newX][0] = true
                        queue.add(intArrayOf(newY, newX, cnt + 1, 0))
                    } else if (map[newY][newX] == 1 && visited[newY][newX][1].not()) {
                        visited[newY][newX][1] = true
                        queue.add(intArrayOf(newY, newX, cnt + 1, 1))
                    }
                } else { // 부숨
                    if (map[newY][newX] == 0 && visited[newY][newX][1].not()) {
                        visited[newY][newX][1] = true
                        queue.add(intArrayOf(newY, newX, cnt + 1, 1))
                    }
                }
            }
        }
    }
    println(if (answer == Int.MAX_VALUE) -1 else answer)
}