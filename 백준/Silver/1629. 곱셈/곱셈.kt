fun main() {
    val (A, B, C) = readln().split(" ").map { it.toInt() }
    // A를 B번 곱한 수를 C로 나누어 출력
    println(diverse(A.toLong(), B.toLong(), C))
}

fun diverse(A: Long, B: Long, C: Int): Long {
    if (B == 1L) return A % C
    else if (B % 2 == 0L) {
        val a = diverse(A, B / 2, C) % C
        return a * a % C
    } else {
        return diverse(A, B / 2, C) % C * diverse(A, B / 2 + 1, C) % C
    }
}