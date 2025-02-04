class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        val remain : List<Int> = progresses.withIndex().map{ (idx,progress) ->
            var day = (100 - progress) / speeds[idx]
            if((100 - progress) % speeds[idx] != 0) day += 1
            day
        }
        var max = remain[0]
        var cnt = 0
        for(day in remain){
            if (max < day){ // 함께 배포 불가능
                answer += intArrayOf(cnt)
                cnt = 1
                max = day
            }
            else{ // 함께 배포 가능
                cnt++
            }
        }
        answer += intArrayOf(cnt)
        return answer
    }
}
