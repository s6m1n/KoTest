fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val answer = IntArray(M)
    back(answer, nums, 0)
}

fun back(answer: IntArray, nums: IntArray, idx: Int) {
    if (idx == answer.size) {
        println(answer.joinToString(" "))
        return
    }
    for (i in nums.indices) {
        if (!answer.contains(nums[i])) {
            answer[idx] = nums[i]
            back(answer.copyOf(), nums, idx + 1)
        }
    }
}