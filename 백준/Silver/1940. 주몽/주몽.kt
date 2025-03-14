import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt() // 재료 수
    val M = readLine().toInt() // 갑옷 만들 수
    val array: IntArray = readLine().split(" ").map { it.toInt() }.toIntArray()
    val queue: Queue<Int> = LinkedList(array.toList())
    val search: Queue<Int> = LinkedList()
    var answer = 0
    for (num in array) {
        val target = queue.poll()
        if (search.contains(target)) {
            answer++
            search.remove(target)
        } else {
            search.add(M - target)
        }
    }
    println(answer)
}