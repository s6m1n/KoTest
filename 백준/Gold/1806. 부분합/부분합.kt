fun main() = with(System.`in`.bufferedReader()) {
    val (N, S) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }
    var left = 0
    var right = 0
    var sum = 0
    var min = Int.MAX_VALUE
    while (right < N) {
        sum += arr[right++]
        while (S <= sum) { // left 이동시킬 조건
            sum -= arr[left++]
            min = minOf(min, right - left + 1)
        }
    }
    println(if (min == Int.MAX_VALUE) 0 else min)
}
