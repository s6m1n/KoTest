fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val nums = (1..N).toList().toIntArray() // 뽑을 수 있는 후보들
    val answer = IntArray(M)
    back(answer.copyOf(), nums, 0)
}

fun back(answer: IntArray, nums: IntArray, idx: Int) {
    if (idx == answer.size) {
        println(answer.joinToString(" "))
        return
    } else {
        for (i in nums.indices) {
            if (!answer.contains(nums[i])) {
                answer[idx] = nums[i]
                back(answer.copyOf(), nums, idx + 1)
            }
        }
    }
}