fun main() {
    val n = readln().toInt() // 노드의 개수 (1 ≤ n ≤ 10,000)
    val list = List(n + 1) { mutableListOf<IntArray>() }
    var visited = BooleanArray(n + 1) { false }
    val checked = BooleanArray(n + 1) { false }
    val candidates = (1..n).toMutableList()
    repeat(n - 1) {
        val (start, end, weight) = readln().split(" ").map { it.toInt() }
        list[start].add(intArrayOf(end, weight))
        list[end].add(intArrayOf(start, weight))
        candidates.remove(start)
    }
    fun dfs(origin: Int, start: Int): Int {
        visited[start] = true // 방문 처리
        if (list[start].size == 1 && start != origin) { // 말단이면
            return 0
        }
        var max = 0
        for (next in list[start]) { // 연결된 노드 중
            if (!visited[next[0]] && !checked[next[0]]) { // 방문하지 않은 곳만 체크
                val tmp = dfs(origin, next[0]) + next[1]
                if (max < tmp) max = tmp
            }
        }
        return max // origin에서 갈 수 있는 최대 거리
    }

    var max = 0
    for (start in candidates) {
        checked[start] = true
        val tmp = dfs(start, start)
        if (max < tmp) max = tmp
        visited = BooleanArray(n + 1) { false }
    }
    println(max)
}