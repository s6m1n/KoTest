fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine()
    var answer = 0
    val input = readLine().split(" ").map { it.toInt() }
    input.forEach {
        if (isPrime(it)) answer++
    }
    println(answer)
}

fun isPrime(N: Int): Boolean {
    if (N <= 1) return false
    else if (N <= 3) return true
    else if (N % 2 == 0 || N % 3 == 0) return false

    var i = 5
    while (i * i <= N) {
        if (N % i == 0 || N % (i + 2) == 0) return false
        i += 6
    }
    return true
}