fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    dfs(IntArray(M), 0, 1, N, M)
}

fun dfs(num: IntArray, idx: Int, start: Int, N: Int, M: Int) {
    if (idx == M) {
        println(num.joinToString(" "))
        return
    }
    for (n in start..N) {
        num[idx] = n
        dfs(num, idx + 1, n, N, M)
    }
}