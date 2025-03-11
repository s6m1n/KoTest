import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val apt = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 1 until N) {
        apt[i][0] += min(apt[i - 1][1], apt[i - 1][2])
        apt[i][1] += min(apt[i - 1][0], apt[i - 1][2])
        apt[i][2] += min(apt[i - 1][0], apt[i - 1][1])
    }
    println(min(apt[N - 1][2], min(apt[N - 1][0], apt[N - 1][1])))
}