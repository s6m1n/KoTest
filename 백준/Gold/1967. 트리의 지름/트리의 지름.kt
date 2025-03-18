fun main() {
    val n = readln().toInt() // 노드의 개수 (1 ≤ n ≤ 10,000)
    val list = List(n + 1) { mutableListOf<IntArray>() }
    var visited = BooleanArray(n + 1) { false }
    repeat(n - 1) {
        val (start, end, weight) = readln().split(" ").map { it.toInt() }
        list[start].add(intArrayOf(end, weight))
        list[end].add(intArrayOf(start, weight))
    }
    var max = 0
    var max_idx = 0
    fun dfs(origin: Int, start: Int, sum: Int) {
        visited[start] = true
        if (list[start].size == 1 && origin != start) {
            if (max < sum) {
                max = sum
                max_idx = start
            }
        }
        for (next in list[start]) {
            if (!visited[next[0]]) {
                dfs(origin, next[0], sum + next[1])
            }
        }
    }
    dfs(1, 1, 0)
    visited.fill(false)
    dfs(max_idx, max_idx, 0)
    println(max)
}