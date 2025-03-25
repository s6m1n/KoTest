import java.io.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val wine = Array(3) { IntArray(n) }
    repeat(n) {
        wine[0][it] = readLine().toInt()
    }
    if (n == 1) {
        println(wine[0][0])
        return
    }
    wine[1][0] = wine[0][0]
    wine[1][1] = wine[0][1]
    wine[2][1] = wine[0][0] + wine[0][1]
    var answer = wine[1][0]
    for (i in 2 until n) {
        val glass = wine[0][i]
        wine[1][i] = answer + glass // 안 먹고 온 거
        wine[2][i] = wine[1][i - 1] + glass // 먹고 온 거
        answer = max(answer, max(wine[1][i-1], wine[2][i-1]))
    }
    answer = max(answer, max(wine[1][n-1], wine[2][n-1]))
    println(answer)
}