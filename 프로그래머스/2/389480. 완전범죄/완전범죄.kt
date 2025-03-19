class Solution {
    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        var candidates = mutableSetOf(Pair(0, 0)) // 초기 상태 (0,0)에서 시작
        for ((a, b) in info) {
            val newSet = mutableSetOf<Pair<Int, Int>>() // 새로운 상태를 저장할 Set
            for ((prevA, prevB) in candidates) {
                if (prevB + b < m) newSet.add(Pair(prevA, prevB + b)) // B도둑이 훔치는 경우
                if (prevA + a < n) newSet.add(Pair(prevA + a, prevB)) // A도둑이 훔치는 경우
            }
            candidates = newSet // 업데이트
        }
        return candidates.minByOrNull { it.first }?.first ?: -1
    }
}
