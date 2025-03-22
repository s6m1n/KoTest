class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        val stack = ArrayDeque<Int>()
        return dfs(0, 0, target, numbers)
    }
}

fun dfs(num:Int, idx:Int, target:Int, numbers:IntArray):Int{
    return if(idx == numbers.size){
        if(target == num) 1
        else 0
    }else{
        dfs(num+numbers[idx],idx+1,target,numbers) + dfs(num-numbers[idx],idx+1,target,numbers)
    }
}