import java.io.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val maze = Array(2) { IntArray(n){-1} }
    maze[0] = readLine().split(" ").map { it.toInt() }.toIntArray()
    maze[1][0] = 0
    for (i in 0 until n) {
        val maxStep = maze[0][i]
        val prevStep = maze[1][i]
        if(prevStep != -1){
            for (step in 1..maxStep.coerceAtMost(n - i - 1)) {
                if (maze[1][i + step] == -1) maze[1][i + step] = prevStep + 1
                else maze[1][i + step] = min(maze[1][i + step], prevStep + 1)
            }
        }
    }
    val result = maze[1][n - 1]
    println(if (result == -1) -1 else result)
}