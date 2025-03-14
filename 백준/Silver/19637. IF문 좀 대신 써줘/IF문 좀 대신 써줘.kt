import java.io.BufferedReader
import java.io.InputStreamReader

// 나보다 같거나 큰(이상인) 수의 칭호 -> lowerBound
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val badges: Array<String> = Array(N) { "" }
    val badgeThreshold = IntArray(N) { 0 }
    val answer = Array(M) { "" }
    for (i in 0 until N) {
        val (badge, threshold) = readLine().split(" ")
        badges[i] = badge
        badgeThreshold[i] = threshold.toInt()
    }
    for (i in 0 until M) {
        val power = readLine().toInt()
        val idx = find(power, badgeThreshold)
        answer[i] = badges[idx]
    }
    println(answer.joinToString("\n"))
}

fun find(power: Int, badges: IntArray): Int {
    var left = 0
    var right = badges.size - 1
    var p = 0
    while (left < right) {
        p = (right - left) / 2 + left
        if (power <= badges[p]) {
            right = p
        } else {
            left = p + 1
        }
    }
    return left
}