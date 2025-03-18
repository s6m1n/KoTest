fun main() {
    val A = readln().toInt() // 게임을 진행하는 사람 A명
    val T = readln().toInt() // T번째 구호를 찾아라 (T ≤ 10000)
    val F = readln().toInt() // 구하고자 하는 구호가 “뻔”이면 0, “데기”면 1
    var sum = IntArray(10001) // i회차마다 몇번째 구호까지 포함하는지
    sum[1] = 4 // 1회차는 4개 // 4 9 6 7 8 ...
    for (i in 2 until 10001) {
        sum[i] = sum[i - 1] + i + 3
    }
    for (i in 0 until 10001) {
        if (T <= sum[i]) { // 답은 i 회차 중에 있음
            var nums = intArrayOf(0, 1, 0, 1)
            repeat(i + 1) {
                nums += intArrayOf(0)
            }
            repeat(i + 1) {
                nums += intArrayOf(1)
            }
            var cnt = T - sum[i - 1]
            var answer = 0
            for (x in 1 .. nums.size) {
                if (nums[x-1] == F) cnt--
                if (cnt <= 0) {
                    answer = x
                    break
                }
            }
            println((sum[i - 1] * 2 + answer - 1) % A)
            break
        }
    }
}
