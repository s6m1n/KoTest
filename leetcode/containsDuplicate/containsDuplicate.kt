package leetcode.containsDuplicate

fun main() {
    val nums = intArrayOf(1, 2, 3, 10, 4, 5)
    val answer = containsDuplicate(nums)
    println(answer)
}

fun containsDuplicate(nums: IntArray): Boolean {
    val numSet = hashSetOf<Int>()
    nums.forEach { num ->
        if (!numSet.add(num)) {
            return true
        }
    }
    return false
}
