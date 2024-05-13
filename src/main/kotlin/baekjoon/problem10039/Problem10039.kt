package baekjoon.problem10039

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var sum = 0
    repeat(5) {
        sum += readLine().toInt().let { if (it < 40) 40 else it }
    }
    println(sum/5)
}