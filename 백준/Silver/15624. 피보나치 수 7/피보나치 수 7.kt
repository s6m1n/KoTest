import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    if (n == 0 || n == 1) {
        println(n)
        return
    }
    val sum = IntArray(n + 1)
    sum[1] = 1
    for (idx in 2..n) {
        sum[idx] = (sum[idx - 2] + sum[idx - 1]) % 1_000_000_007
    }
    println(sum[n])
}
