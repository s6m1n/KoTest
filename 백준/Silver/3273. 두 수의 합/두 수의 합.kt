fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = readLine().split(" ").map { it.toInt() }.sorted()
    val x = readLine().toInt()
    var cnt = 0
    var start = 0
    var end = n - 1
    while (start < end) {
        when {
            (array[start] + array[end] == x) -> {
                cnt++; start++; end--
            }

            (array[start] + array[end] < x) -> {
                start++
            }

            (x < array[start] + array[end]) -> {
                end--
            }
        }
    }
    println(cnt)
}