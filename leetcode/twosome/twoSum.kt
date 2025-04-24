package LeetCode

fun main() {
    val nums = intArrayOf(3,3)
    val target = 6 // 답 : 0, 1
//    val nums = intArrayOf(3, 2, 4)
//    val target = 6 // 답 : 1, 2
//    val nums = intArrayOf(2, 7, 11, 15)
//    val target = 9 // 답 : 0, 1
    val answer = solutionOn1(nums, target)
    println(answer.joinToString(", "))
}

fun solutionOn2(nums: IntArray, target: Int): IntArray {
    var answer: Pair<Int, Int> = Pair(0, 0)
    for (firstIdx in nums.indices) {
        for (secondIdx in firstIdx + 1..<nums.size) {
            if (nums[firstIdx] + nums[secondIdx] == target) {
                answer = firstIdx to secondIdx
                break
            }
        }
    }
    return intArrayOf(answer.first, answer.second)
}

fun solutionOn1(nums: IntArray, target: Int): IntArray {
    var answer = 0 to 0
    val candidates = emptyMap<Int,Int>().toMutableMap()
    for ((idx, num) in nums.withIndex()) {
        if (candidates.containsKey(num)) {
            answer = candidates[num]!! to idx
            break
        } else {
            candidates[target - num] = idx
        }
    }
    return intArrayOf(answer.first, answer.second)
}
