import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val answer = LongArray(N+1)
    if(N==1){
        println(1)
        return
    }
    answer[1] = 1
    answer[2] = 2
    for (i in 3 until N+1) {
        answer[i] = (answer[i - 1] + answer[i - 2])% 10007
    }
    println(answer[N])
}