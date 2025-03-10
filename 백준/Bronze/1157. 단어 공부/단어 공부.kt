import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val text: Map<Char, Int> = readLine().map { it.uppercaseChar() }.groupingBy { it }.eachCount()
    val list: List<Pair<Char, Int>> = text.map { it.key to it.value }.sortedByDescending { it.second }
    if (1 < list.size) {
        if (list[0].second == list[1].second) {
            println("?")
            return
        }
    }
    println(list[0].first)
}