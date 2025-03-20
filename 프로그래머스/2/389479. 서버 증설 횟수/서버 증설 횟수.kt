import java.util.*

class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0 // 증설횟수
        var queue : Queue<Int> = LinkedList()
        for(t in players.indices){
            while(queue.peek()?:Int.MAX_VALUE <= t - k){ // 시간 다 되면 서버 제거
                queue.poll()
            }
            if(queue.size < players[t]/m){ // 해당 시간의 유저 수로부터 필요 서버 수 계산
                val shortage = players[t]/m - queue.size
                answer+= shortage
                repeat(shortage){
                    queue.add(t)   
                }
            }
        }
        return answer
    }
}