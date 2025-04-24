class Solution {
    fun addBinary(a: String, b: String): String {
        var longerString = if (a.length >= b.length) a else b
        val shorterString = if (a.length < b.length) a else b
        val correction = longerString.length - shorterString.length
        var carry : Int = 0
        var result : Int = 0
        var answer : String = ""
        for(idx in longerString.length - 1 downTo 0){
            var target = longerString[idx].digitToInt() + carry
            if(correction <= idx) target += shorterString[idx - correction].digitToInt()
            when(target){
                0 -> { // result = 0 carry = 0
                    result = 0
                    carry = 0
                 }
                1 -> { // result = 1 carry = 0
                    result = 1
                    carry = 0
                 }
                2 -> { // result = 0 carry = 1
                    result = 0
                    carry = 1
                 }
                3 -> { // result = 1 carry = 1
                    result = 1
                    carry = 1
                 }
            }
            answer = result.toString() + answer
        }
        if(carry!=0) answer = "1" + answer
        return answer
    }
}

/*

binary calculate

1 + 1 -> 0 , carry = 1
1 + 0 -> 1 , carry = 0
0 + 0 -> 0 , carry = 0

a = "1010", b = "1011"

1
0, carry = 1
1
0, carry = 1

a = "1111111", b = "1111"

0, carry = 1
1, carry = 1
3 -> 11

2^3, 2^2, 2^1, 2^0
8,   4,   2,   1
7/2 -> 3
6/3 -> 4
8/2 -> 4

10/2 -> 5/2 -> 2/2 -> 0




 */