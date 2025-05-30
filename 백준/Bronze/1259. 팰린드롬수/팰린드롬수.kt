fun main() = with(System.`in`.bufferedReader()) {
    while(true){
        val a = readLine()
        if(a=="0") break
        check(a)
    }
}

fun check(a:String) {
    var isPelindrom = true
    var start = 0
    var end = a.length - 1
    while(start<end){
        if(a[start]!=a[end]) {
            isPelindrom = false
            break
        }
        start++
        end--
    }
    println(if (isPelindrom) "yes" else "no")
}