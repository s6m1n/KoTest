var r: Int = 0
var c: Int = 0

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val (R, C) = readLine().split(" ").map { it.toInt() }
    r = R
    c = C
    val arr: Array<String> = Array(R) { readLine() }
    val mask = 0
    println(dfs(0, 0, arr, mask.on(arr[0][0])))
}

fun dfs(y: Int, x: Int, arr: Array<String>, mask: Int): Int {
    var max = mask.countOneBits()
    for (idx in 0..3) {
        val newY = y + dy[idx]
        val newX = x + dx[idx]
        if (newY in 0..<r && newX in 0..<c) { // 검사 가능한 범위
            if (arr[newY][newX].check(mask).not()) { // 처음 보는 알파벳이면
                max = maxOf(max, dfs(newY, newX, arr, mask.on(arr[newY][newX])))
            }
        }
    }
    return max
}

val dy = intArrayOf(0, 1, 0, -1)
val dx = intArrayOf(1, 0, -1, 0)
fun Char.check(mask: Int): Boolean = (mask and (1 shl (this.code - 'A'.code))) != 0
fun Int.on(char: Char): Int = this or (1 shl (char.code - 'A'.code))