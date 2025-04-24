package leetcode.validParentheses

import java.util.*

fun main() {
    val str = "()[]{}"
    val answer = isValid(str)
    println("answer = $answer")
}

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    var answer = true
    for (char in s) {
        when (char) {
            '(' -> {
                stack.push(char)
            }

            '{' -> {
                stack.push(char)
            }

            '[' -> {
                stack.push(char)
            }

            ')' -> {
                val target = stack.peek()
                if (target != '(') {
                    answer = false
                    break
                } else {
                    stack.pop()
                }
            }

            '}' -> {
                val target = stack.peek()
                if (target != '{') {
                    answer = false
                    break
                } else {
                    stack.pop()
                }
            }

            ']' -> {
                val target = stack.peek()
                if (target != '[') {
                    answer = false
                    break
                } else {
                    stack.pop()
                }
            }

            else -> throw IllegalArgumentException()
        }
    }
    return if (!stack.isEmpty()) false else answer
}
