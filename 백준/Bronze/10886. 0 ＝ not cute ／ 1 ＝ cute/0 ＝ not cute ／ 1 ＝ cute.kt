import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    var cnt = 0
    repeat(N) {
        if (readLine().toInt() == 0) cnt--
        else cnt++
    }
    if (cnt < 0) println("Junhee is not cute!")
    else println("Junhee is cute!")
}
