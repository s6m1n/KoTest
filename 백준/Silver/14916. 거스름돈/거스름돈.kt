import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val array = IntArray(N + 1) { 999 }
    if (N == 0 || N == 1 || N == 3) {
        println(-1)
    } else if (N == 2 || N == 5) {
        println(1)
    } else if (N == 4) {
        println(2)
    } else {
        array[2] = 1
        array[4] = 2
        array[5] = 1
        for (i in 6..N) {
            array[i] = min(array[i - 2], array[i - 5]) + 1
        }
        println(array[N])
    }
}