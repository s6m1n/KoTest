class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer = genres.indices
            .groupBy { genres[it] } // idx 기준으로 groupBy -> Map<String, list>
            .toList()
            .sortedByDescending { it.second.sumOf { idx -> plays[idx] } } // 총 재생 수가 많은 장르 순으로 정렬
            .map {
                it.second
                    .sortedByDescending { idx -> plays[idx] } // 재생 수가 높은 노래 순으로 정렬
                    .take(2) // 상위 2개만
            }
            .flatten()
            .toIntArray()
        return answer
    }

}