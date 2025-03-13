import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val hole = readLine().split(" ").map { it.toInt() }.toIntArray()
    val answer = IntArray(N)
    var start = 0
    answer[0] = if(hole[0]<M) {
        hole[0]
    } else {
        start++
        0
    }
    for (i in 1 until N) {
        answer[i] = answer[i - 1] + hole[i]
        if (M < answer[i]) {
            while (M < answer[i] && start <= i) {
                answer[i] -= hole[start]
                start++
            }
        }
        if (M == answer[i]) {
            println(M)
            return
        }
//        println(answer.joinToString(", "))
    }
    println(answer.max())
}