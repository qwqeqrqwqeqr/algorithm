package baekjoon.problem25026

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var total = 0.0
    var sum = 0.0
    repeat(20) {
        val (a, b, c) = readLine().split(" ")
        if(c!="P"){
            total += b.toDouble()
            sum += b.toDouble() * when (c) {
                "A+" -> 4.5
                "A0" -> 4.0
                "B+" -> 3.5
                "B0" -> 3.0
                "C+" -> 2.5
                "C0" -> 2.0
                "D+" -> 1.5
                "D0" -> 1.0
                else -> 0.0
            }
        }
    }
    println(sum/total)
}