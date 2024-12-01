class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val answer = mutableMapOf<String, MutableList<String>>()
        strs.forEach { str ->
            val target = sortString(str)
            if(answer.contains(target)) answer[target]!!.add(str)
            else answer[target] = mutableListOf(str)
        }
        return answer.values.toList()
    }

    fun sortString(str:String):String{
        val result = str.toCharArray().sorted().joinToString(\\)
        print(result)
        return result
    }
}