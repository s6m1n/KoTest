import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val vertex = readLine().toInt() // 정점 수 <= 100
    val edge = readLine().toInt() // 간선 수 <= 100,000
    val array = Array(vertex + 1) { IntArray(vertex + 1) { 0 } } // 101 * 101 = 10100
    repeat(edge) {
        val (start, end, weight) = readLine().split(" ").map { it.toInt() }
        if (array[start][end] == 0) {
            array[start][end] = weight
        } else if (weight < array[start][end]) {
            array[start][end] = weight
        }
    }
    for (mid in 1..vertex) { // 경유지
        for (start in 1..vertex) { // 시작
            if (start != mid) {
                for (end in 1..vertex) { // 끝
                    if (end != mid && end != start) {
                        if (array[start][mid] != 0 && array[mid][end] != 0) {
                            if (array[start][end] == 0) {
                                array[start][end] = array[start][mid] + array[mid][end]
                            } else {
                                array[start][end] = minOf(array[start][end], array[start][mid] + array[mid][end])
                            }
                        }
                    }
                }
            }
        }
    }

    println(array.takeLast(vertex).joinToString("\n") { it.takeLast(vertex).joinToString(" ") })
}