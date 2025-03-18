import java.util.*

fun main() {
    val (M, N, H) = readln().split(" ").map { it.toInt() }
    // M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수
    val array = Array(H) { Array(N) { IntArray(M) } }
    val queue: Queue<IntArray> = LinkedList()
    var cnt = 0
    repeat(H) { h ->
        repeat(N) { n ->
            array[h][n] = readln().split(" ").map { it.toInt() }.toIntArray()
            for (idx in 0 until M) {
                if (array[h][n][idx] == 1) {
                    queue.add(intArrayOf(h, n, idx))
                }
                if (array[h][n][idx] == 0) cnt++
            }
        }
    }
    val flag = intArrayOf(-1, -1, -1)
    val dh = intArrayOf(1, -1, 0, 0, 0, 0)
    val dn = intArrayOf(0, 0, 1, -1, 0, 0)
    val dm = intArrayOf(0, 0, 0, 0, 1, -1)
    var day = 0
    queue.add(flag)
    while (queue.isNotEmpty()) {
        val start = queue.poll()
        val (h, n, m) = start
        if (start.contentEquals(flag)) {
            day++
            if (queue.isNotEmpty()) queue.add(flag)
            else break
        }
        for (i in 0 until 6) {
            val newH = h + dh[i]
            val newN = n + dn[i]
            val newM = m + dm[i]
            if (newH in (0 until H) && newM in (0 until M) && newN in (0 until N)) {
                if (array[newH][newN][newM] == 0) {
                    cnt--
                    queue.add(intArrayOf(newH, newN, newM))
                    array[newH][newN][newM] = 1
                }
            }
        }
    }
    println(if (cnt != 0) -1 else day - 1)
}