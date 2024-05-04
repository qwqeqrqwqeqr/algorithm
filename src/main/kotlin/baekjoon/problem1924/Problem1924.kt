package baekjoon.problem1924

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (m, d) = readLine().split(" ").map { it.toInt() }
    var sum = 0
    for (i in 1 until m) {
        sum += when (i) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            else -> 28
        }
    }
    println(
        when ((sum + d) % 7) {
            0 -> "SUN"
            1 -> "MON"
            2 -> "TUE"
            3 -> "WED"
            4 -> "THU"
            5 -> "FRI"
            else -> "SAT"
        }
    )
}