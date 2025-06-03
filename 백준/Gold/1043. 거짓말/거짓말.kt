fun main(): Unit = with(System.`in`.bufferedReader()) {
    // 사람의 수 N, 파티의 수 M
    val (N, M) = readLine().split(" ").map { it.toInt() }
    var answer = -1
    var cases = BooleanArray(N) { true }
    // people : 진실을 아는 사람 번호
    var truePeople = readLine().split(" ").map { it.toInt() }
    if (truePeople[0] == 0) {
        answer = M
    } else {
        truePeople = truePeople.slice(1..truePeople[0])
    }
    val party = Array(M) {
        val input = readLine().split(" ").map { it.toInt() }
        input.slice(1..input[0])
    }
    if (answer == 0) {
        println(M)
        return
    }
    println(dfs(0, 0, party, truePeople.toSet(), emptySet()))
}

fun dfs(
    idx: Int,
    cnt: Int,
    party: Array<List<Int>>, // 파티 참가자 정보
    truePeople: Set<Int>,
    falsePeople: Set<Int>
): Int {
    if (idx == party.size) return cnt
    // 거짓말 할 수 있는 경우 : 진실을 아는 사람들이 없을 때
    // 진실을 말할 수 있는 경우 : 거짓을 아는 사람들이 없을 때
    // 그 외 : 불가능한 케이스
    val partyPeople = party[idx]
//        .filterNot { truePeople.contains(it) && !falsePeople.contains(it) }
    val falseCase = if (partyPeople.all { !truePeople.contains(it) }) { // 해당 파티 참가자 중 진실을 아는 사람이 없다면
        // 거짓말 한다
        dfs(idx + 1, cnt + 1, party, truePeople.toSet(), falsePeople + partyPeople)
    } else 0
    val trueCase = if (partyPeople.all { !falsePeople.contains(it) }) { // 거짓을 아는 사람이 없다면
        // 진실을 말한다
        dfs(idx + 1, cnt, party, truePeople + partyPeople, falsePeople.toSet())
    } else 0
    return maxOf(falseCase, trueCase)
}
