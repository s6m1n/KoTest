import java.io.BufferedReader
import java.io.InputStreamReader
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = 14 + 1
    val N = readLine().toInt()
    val apt = Array(size) { IntArray(size) }
    repeat(size) {
        apt[0][it] = it
    }
    for (j in 1 until size) {
        apt[j][1] = apt[j - 1][1]
        for (i in 1 until size) {
            apt[j][i] = apt[j][i - 1] + apt[j - 1][i]
        }
    }
    repeat(N) {
        val k = readLine().toInt() // k층
        val n = readLine().toInt() // n호
        println(apt[k][n])
    }
}