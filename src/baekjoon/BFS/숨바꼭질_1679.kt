package BFS

import java.io.BufferedReader
import java.io.InputStreamReader

private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val input = reader.readLine().split(" ").map { it.toInt() }
    solution(input[0], input[1])
}

fun solution(N: Int, K: Int) {
    var answer = -1 to -1
    val candidates = ArrayDeque<Pair<Int, Int>>() // 걸린 시간 to 위치
    val visited = IntArray(100_001) { 0 }
    addCandidate(N, visited, candidates, 0)
    if (K < N) answer = N - K to N
    else {
        while (0 < candidates.size) {
            val target = candidates.removeFirst()
            if (target.second == K) {
                answer = target
                break
            } else if (target.second - 1 == K || target.second + 1 == K || target.second * 2 == K) {
                answer = target.first + 1 to target.second
                break
            } else {
                if (0 <= target.second - 1) {
                    addCandidate(target.second - 1, visited, candidates, target.first + 1)
                }
                if (target.second + 1 <= 100_000) {
                    addCandidate(target.second + 1, visited, candidates, target.first + 1)
                }
                if (target.second * 2 <= 100_000) {
                    addCandidate(target.second * 2, visited, candidates, target.first + 1)
                }
            }
        }
    }
    println(answer.first)
}

fun addCandidate(newPosition: Int, visited: IntArray, candidates: ArrayDeque<Pair<Int, Int>>, time: Int) {
    if (visited[newPosition] == 0) {
        visited[newPosition] = 1
        candidates.add(time to newPosition)
    }
}
