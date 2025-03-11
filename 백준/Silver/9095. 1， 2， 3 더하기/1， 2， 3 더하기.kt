import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt()
    val answer = IntArray(12)
    answer[1] = 1
    answer[2] = 2
    answer[3] = 4
    for (i in 4..11) {
        answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3]
    }
    repeat(T) {
        println(answer[readLine().toInt()])
    }
}
