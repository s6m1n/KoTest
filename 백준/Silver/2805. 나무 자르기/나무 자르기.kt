import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    var trees: LongArray = readLine().split(" ").map { it.toLong() }.sortedDescending().toLongArray()
    var bottom: Long = 0
    var top: Long = trees[0]
    var p = (top - bottom) / 2 + bottom
    var max = p
    while (bottom <= top) {
        p = (top - bottom) / 2 + bottom
        var treeSum = cut(p, trees)
        if (M < treeSum) {
            max = p
            bottom = p + 1
        } else if (treeSum < M) {
            top = p - 1
        } else {
            max = p
            break
        }
    }
    println(max)
}

fun cut(p: Long, trees: LongArray): Long {
    var sum = 0L
    for (tree in trees) {
        sum += if (tree - p > 0) (tree - p) else 0
    }
    return sum
}