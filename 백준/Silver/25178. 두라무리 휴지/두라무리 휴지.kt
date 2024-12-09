fun main() {
    val n = readln().toInt()
    val origin = readln()
    val new = readln()
    if(isSameUnion(origin,new) && checkFirstAndList(origin,new) && checkWithoutVowels(origin,new)) println("YES")
    else println("NO")
}

fun isSameUnion(origin: String, new: String): Boolean {
    val originMap = origin.groupingBy { it }.eachCount()
    val newMap = new.groupingBy { it }.eachCount()
    return (originMap == newMap)
}

fun checkFirstAndList(origin: String, new: String): Boolean {
    return (origin[0] == new[0] && origin.last() == new.last())
}

fun checkWithoutVowels(origin: String, new: String): Boolean {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val originWithoutVowels = origin.filter { vowels.contains(it).not() }
    val newWithoutVowels = new.filter { vowels.contains(it).not() }
    return originWithoutVowels == newWithoutVowels
}