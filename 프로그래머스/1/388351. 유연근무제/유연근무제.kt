class Solution {
    fun solution(
        schedules: IntArray,
        timelogs: Array<IntArray>,
        startday: Int,
    ): Int {
        var answer: Int = 0
        
        for(idx in schedules.indices) { // idx -> each people's idx
            var isLateComer = false
            var day = startday
            val s = schedules[idx]
            for(timelog in timelogs[idx]) { // each day
                if(day != 6 && day != 7) { // only weekday
                    if(!validTime(s, timelog)) { // check if he late
                        isLateComer = true
                        break
                     }
                }
                day = (day % 7) + 1
            }
            if(!isLateComer) answer++
        }
        return answer
    }
    
    fun validTime(schedule : Int, timelog : Int) : Boolean {
        var minutes = schedule % 100 + 10
        var hour = schedule / 100
        if(60 <= minutes) {
            hour += 1
            minutes -= 60
        }
        val tMinutes = timelog % 100
        val tHour = timelog / 100

        return (tHour < hour) || (tHour == hour && tMinutes <= minutes)
    }
}