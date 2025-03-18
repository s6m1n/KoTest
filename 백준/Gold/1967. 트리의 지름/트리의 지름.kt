fun main() {
    val n = readln().toInt() // 노드의 개수 (1 ≤ n ≤ 10,000)
    val list = List(n + 1) { mutableListOf<IntArray>() }
    val visited = BooleanArray(n + 1) { false }
    repeat(n - 1) {
        val (start, end, weight) = readln().split(" ").map { it.toInt() }
        list[start].add(intArrayOf(end, weight))
        list[end].add(intArrayOf(start, weight))
    }
    var max = 0
    var max_idx = 0
    fun dfs(start: Int, sum: Int) {
        visited[start] = true
        if (max < sum) {
            max = sum
            max_idx = start
        }
        for ((next, weight) in list[start]) {
            if (!visited[next]) {
                dfs(next, sum + weight)
            }
        }
    }
    dfs(1, 0)
    visited.fill(false)
    dfs(max_idx, 0)
    println(max)
}