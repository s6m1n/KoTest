import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val array = IntArray(N + 1) { -1 }
    if (2 < N) {
        array[3] = 1
    }
    if (4 < N) {
        array[5] = 1
    }
    for (i in 6..N) {
        if (array[i - 3] != -1 && array[i - 5] != -1) array[i] = min(array[i - 3], array[i - 5]) + 1
        else if (array[i - 3] != -1) array[i] = array[i - 3] + 1
        else if (array[i - 5] != -1) array[i] = array[i - 5] + 1
    }
    println(array[N])
}