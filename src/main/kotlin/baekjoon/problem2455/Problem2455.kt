package baekjoon.problem2455

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    var max = Int.MIN_VALUE
    var temp = 0
    repeat(4) {
        readLine().split(" ").map { it.toInt() }.also {
            temp -= it[0]
            temp += it[1]
        }
        max = Math.max(max, temp)
    }
    println(max)
}