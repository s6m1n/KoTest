class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()
        val sort = mutableMapOf<String, MutableList<Pair<Int, Int>>>()
        for ((idx, genre) in genres.withIndex()) {
            sort[genre]?.add(plays[idx] to idx) ?: run {
                sort[genre] = mutableListOf(plays[idx] to idx)
            }
        }
        val sortedList = sort.entries.sortedBy { -it.value.sumOf { it.first } }
        for (genreSongs in sortedList) {
            val sortedGenre = genreSongs.value.sortedBy { -it.first }
            for(songIdx in sortedGenre.indices){
                if(1 < songIdx) break
                answer += intArrayOf(sortedGenre[songIdx].second)
            }
        }
        return answer
    }
}