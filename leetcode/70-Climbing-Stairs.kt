class Solution {
    fun climbStairs(n: Int): Int {
        if(n<=3) return n // n == floor, 1 <= n <= 45
        val answer = IntArray(n){0}
        answer[0]=1
        answer[1]=2
        answer[2]=3
        for(floor in 3 until n){
            answer[floor] = answer[floor-1] + answer[floor-2]
        }

        return answer[n-1]
    }
}

/*
DP
recurrence relation
we need to consider the case 2 steps before

5                  ____
3              ____
2         ____
1     ____
  ____
n -> ways

1 -> 1 (1)

2 -> 1+1 (2)
     2

3 -> 1+1+1 (3)
     1+2
     2+1

4 -> 1+1+1+1 (5)
     1+2+1
     1+1+2
     2+1+1
     2+2

*/