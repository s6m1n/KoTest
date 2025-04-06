import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()
    var max = 0
    var left = 0
    var oddCount = 0

    for (right in 0 until N) { // right가 끝에 갈 때까지 검사
        if (arr[right] % 2 == 1) oddCount++ // 홀수면 부숴
        while (oddCount > K) { // 넘 많이 부쉈으면 left 이동
            if (arr[left] % 2 == 1) {
                oddCount--
            }
            left++
        }
        max = max(right - left - oddCount + 1, max)
    }
    println(max)
}