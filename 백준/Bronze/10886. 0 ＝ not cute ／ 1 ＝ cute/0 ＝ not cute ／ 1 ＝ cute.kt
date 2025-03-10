import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    var yes = 0
    var no = 0
    repeat(N) {
        if (readLine().toInt() == 0) no++
        else yes++
    }
    if (yes < no) println("Junhee is not cute!")
    else println("Junhee is cute!")
}