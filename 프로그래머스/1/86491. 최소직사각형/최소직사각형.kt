import kotlin.math.*

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        val max : IntArray = sizes[0]
        var min = sizes[0][0] * sizes[0][1]
        for(i in 1 until sizes.size){
            val (x, y) = sizes[i]
            val origin = max(max[0],x) * max(max[1],y)
            val rotate = max(max[0],y) * max(max[1],x)
            if(origin < rotate){ // 안 돌릴 때가 더 좋으면
                max[0] = max(max[0],x)
                max[1] = max(max[1],y)
            }else{
                max[0] = max(max[0],y)
                max[1] = max(max[1],x)
            }
        }
        return max[0] * max[1]
    }
}