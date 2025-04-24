class Solution {
    fun mySqrt(x: Int): Int {
        val x = x.toLong()
        var start : Long = 0 // 2
        var end = x // 4
        var middle : Long = end / 2 // 2 -> 4

        while(start<=end){
            if(x == middle*middle){
                return middle.toInt()
            }
            else if (x < middle*middle) {
            end = middle - 1  // 4
            }
            else{
            start = middle + 1
            }
            middle = start + (end - start) / 2 // 2
            // to do : compare x and middle^2
            // if (x < middle^2) change end
            // else change start
            // set newMiddle
        }
            return start.toInt() - 1
        }
}
