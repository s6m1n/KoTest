fun main() {
    val input = readln().split(" ").map { it.toInt() } // N, K
    val ablePosition = mutableSetOf<Pair<Int,Int>>()
    val directions = arrayOf(intArrayOf(2, 0), intArrayOf(-2, 0), intArrayOf(0, 2), intArrayOf(0, -2))
    repeat(input[1]) {
        val dabbaba = readln().split(" ").map { it.toInt() - 1 }.toIntArray() // X, Y
        ablePosition.add(dabbaba[0] to dabbaba[1])
        for (direction in directions) {
            val movedPosition = dabbaba.zip(direction) { a, b -> a + b } // 이동한 위치
            if (movedPosition.all { it in 0 until input[0] }) {
                ablePosition.add(movedPosition[0] to movedPosition[1])
            }
        }
    }
    println(ablePosition.size-input[1])
}