package leetcode.longestCommonPrefix

fun main() {
    val strs = arrayOf("flower", "flow", "flight")
    val answer = longestCommonPrefix(strs)
    println("answer = $answer")
}

fun longestCommonPrefix(strs: Array<String>): String {
    var target = strs[0]
    for (idx in 1 until strs.size) {
        target = compare(target, strs[idx])
        if (target == "") break
    }
    return target
}

fun compare(str1: String, str2: String): String {
    var result = ""
    val x = if (str1.length < str2.length) str1.length else str2.length
    for (idx in 0 until x) {
        if (str1[idx] == str2[idx]) result += str1[idx]
        else break
    }
    return result
}
