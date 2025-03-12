class Solution {
    fun solution(s: String): String {
        var numbers = s.split(" ").map{it.toInt()}
        var max = numbers[0]
        var min = numbers[0]
        for(num in numbers){
            if(num<min) min = num
            if(max<num) max = num
        }
        return "$min $max"
    }
}