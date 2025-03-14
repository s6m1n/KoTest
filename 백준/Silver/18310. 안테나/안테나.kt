import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val house = readLine().split(" ").map { it.toInt() }.sorted()
    println(house[(N-1)/2])
}