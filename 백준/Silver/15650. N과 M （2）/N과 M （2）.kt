fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val nums = (1..N).toList().toIntArray() // 뽑을 수 있는 후보들
    val answer = IntArray(M)
    back(answer, nums, 0, 0)
}

fun back(answer: IntArray, nums: IntArray, start: Int, idx: Int) {
    if (start == answer.size) {
        println(answer.joinToString(" "))
        return
    } else {
        for (i in idx until nums.size) {
            answer[start] = nums[i]
            back(answer, nums, start + 1, i + 1)
        }
    }
}