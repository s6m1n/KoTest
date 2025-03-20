import kotlin.math.roundToInt

fun main() {
    val N = readln().toInt()
    val array = IntArray(N)
    var sum = 0.0
    repeat(N) { idx ->
        array[idx] = readln().toInt()
        sum += array[idx]
    }
    val sortedArray = array.sorted()
    println((sum / N).roundToInt())
    println(sortedArray[N / 2])
    val frequency = array.toList().groupingBy { it }.eachCount()
    val frequencyList = frequency.toList().sortedBy { it.first }.sortedByDescending { it.second }
    var mostFrequent = frequencyList[0].first
    if(frequency.size>2){
        if(frequencyList[0].second == frequencyList[1].second){
            mostFrequent = frequencyList[1].first
        }
    }
    println(mostFrequent)
    println(sortedArray.last() - sortedArray[0])
}