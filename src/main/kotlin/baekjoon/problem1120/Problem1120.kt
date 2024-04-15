package baekjoon.problem1120


var min = Int.MAX_VALUE
var wildCard = '*'
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ")
    var stringBuilder = StringBuilder()

    for (i in 0..b.length - a.length) {
        val j = (b.length - a.length) - i
        stringBuilder.append(a)
        repeat(i) { stringBuilder.append(wildCard) }
        repeat(j) { stringBuilder.insert(0, wildCard) }

        diff(stringBuilder.toString(), b)
        stringBuilder.clear()
    }

    println(min)
}


fun diff(a: String, b: String) {
    var count = 0
    for (i in a.indices) {
        if(a[i] == wildCard) continue
        if(a[i] != b[i]) count++
    }
    min = Math.min(count, min)
}