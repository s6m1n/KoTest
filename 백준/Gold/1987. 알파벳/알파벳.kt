fun main() =
    with(System.`in`.bufferedReader()) {
        val (R, C) = readLine().split(" ").map { it.toInt() }
        val arr = Array(R) { readLine() }
        val isChecked = BooleanArray(27) { false }
        isChecked[arr[0][0].getCode()] = true
        println(dfs(0, 0, arr, isChecked, R, C))
    }

fun Char.getCode() = this.code - 'A'.code
fun dfs(y: Int, x: Int, arr: Array<String>, isChecked: BooleanArray, R: Int, C: Int): Int {
    var max = isChecked.count { it }
    for (i in 0..3) {
        val newY = y + dy[i]
        val newX = x + dx[i]
        if (newY in 0..<R && newX in 0..<C) { // 갈 수 있는 범위면
            val newChar = arr[newY][newX]
            if (!isChecked[newChar.getCode()]) { // 새로운 문자면
                val newChecked = isChecked.copyOf()
                newChecked[newChar.getCode()] = true
                max = maxOf(max, dfs(newY, newX, arr, newChecked, R, C))
            }
        }
    }
    return max
}

val dy = intArrayOf(1, 0, -1, 0)
val dx = intArrayOf(0, 1, 0, -1)