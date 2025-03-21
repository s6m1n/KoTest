class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        val size = array.size
        for(command in commands){
            val (i, j, k) = command
            val arr2 = array.slice(i-1..j-1).sorted()
            answer+=intArrayOf(arr2[k-1])
        }
        return answer
    }
}