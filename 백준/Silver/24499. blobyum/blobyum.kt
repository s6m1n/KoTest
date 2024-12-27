import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() } // 총 N개의 파이, K개를 먹는다
    val tastes = br.readLine().split(" ").map { it.toInt() } // N개 파이의 맛있음 값
    val sumOfTastes = IntArray(input[0]) // N개 있어야 함
    sumOfTastes[0] = tastes.take(input[1]).sumOf { it }
    var max = sumOfTastes[0]
    var start = 1
    var end = input[1] // K
    while (start < tastes.size) {
        if(end == tastes.size) {
            end = 0
        }
        sumOfTastes[start] = sumOfTastes[start - 1] - tastes[start - 1] + tastes[end]
        if (max < sumOfTastes[start]) max = sumOfTastes[start]
        end++
        start++
    }
    print(max)
}