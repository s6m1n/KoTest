import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() } // 구멍의 크기들
    val answer = check(N, A)
    println(answer.joinToString(" "))
}

fun check(N: Int, arr: List<Int>): MutableList<Int> { // 배열 원소 수, 배열
    var minIdx = 0
    var maxSub = 0
    val answer = mutableListOf(0)
    for (idx in 1 until N) {
        if (arr[minIdx] < arr[idx]) {
            maxSub = maxOf((arr[idx] - arr[minIdx]), maxSub)
            answer.add(maxSub)
        } else if (arr[idx] < arr[minIdx]) {
            answer.add(maxSub)
            minIdx = idx
        }
        else{
            answer.add(maxSub)
        }
    }
    return answer
}