import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() } // 총 N개의 파이, K개를 먹는다
    val tastes = br.readLine().split(" ").map { it.toInt() } // N개 파이의 맛있음 값
    var target = tastes.take(input[1]).sumOf { it }
    var max = target
    var start = 1
    var end = input[1] // K
    while (start < tastes.size) {
        if(end == tastes.size) {
            end = 0
        }
        target = target - tastes[start - 1] + tastes[end]
        if (max < target) max = target
        end++
        start++
    }
    print(max)
}