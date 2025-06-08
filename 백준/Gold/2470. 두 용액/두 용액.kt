import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = readLine().split(" ").map { it.toInt() }.sorted()
    var pair = 0 to 0
    var min = Int.MAX_VALUE
    var start = 0
    var end = n - 1
    while (start < end) {
        val sum = array[start] + array[end]
        if (abs(sum) < min) {
            min = abs(sum)
            pair = array[start] to array[end]
        }
        when {
            (sum == 0) -> break
            (sum < 0) -> start++
            (0 < sum) -> end--
        }
    }
    println("${pair.first} ${pair.second}")
}