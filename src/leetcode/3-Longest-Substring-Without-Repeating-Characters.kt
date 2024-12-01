class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char,Int>()
        var pointer = 0
        var max = 0
        for ((idx,char) in s.withIndex()){
            if(map[char]==null || map[char]?:0 < pointer){
                map[char]=idx
            }
            else{
                if(max < idx - pointer) max = idx - pointer
                pointer = map[char]!! + 1
                map[char] = idx
            }
        }
        if(max < s.length - pointer) max = s.length - pointer
        return max
    }
}

/*
map : a map of characters to their latest indices.
pointer : new start index, which is the next index after the previously found duplicate char.
max : the max length of subsequence encountered so far.

1. Iterate through the String s
2. if the map doesn't have the target character, add it and cnt ++
3. else, compare cnt and max, reset cnt and map
 */