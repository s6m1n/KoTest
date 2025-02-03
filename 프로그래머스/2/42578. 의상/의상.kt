class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        
        val clothesMap = clothes.groupBy{it[1]}
        for(wears in clothesMap){
            val caseNum = wears.value.size + 1
            answer = answer * caseNum
        }
        return answer - 1
    }
}