import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    var cnt = 0
    repeat(N) {
        cnt += if (readLine().toInt() == 0) -1 else +1
    }
    println(if (cnt < 0) "Junhee is not cute!" else "Junhee is cute!")
}
