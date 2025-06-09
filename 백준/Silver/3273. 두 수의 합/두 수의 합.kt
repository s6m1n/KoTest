fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val x = readLine().toInt()
    val map = mutableMapOf<Int, Int>()
    var cnt = 0
    for (idx in 0..<N) {
        if (map[arr[idx]] == 1) { // 나랑 쌍인 친구가 있으면
            cnt++
        } else {
            map[x - arr[idx]] = 1
        }
    }
    println(cnt)
}