fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var array = IntArray(N)
    repeat(N) { line -> // 0부터 시작
        val newLine = readLine().split(" ").map { it.toInt() }.toIntArray()
        if (line == 0) {
            array = newLine
        } else {
            for (idx in newLine.indices) {
                if (idx == 0) {
                    newLine[idx] += array[idx]
                } else if (idx == newLine.size - 1) {
                    newLine[idx] += array[idx - 1]
                } else {
                    newLine[idx] += maxOf(array[idx - 1], array[idx])
                }
            }
            array = newLine
        }
    }
    println(array.max())
}