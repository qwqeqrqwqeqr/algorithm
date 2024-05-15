package baekjoon.problem1085

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (x, y, w, h) = readLine().split(" ").map { it.toInt() }
    println(
        Math.min(
            Math.min(Math.abs(x - w), Math.abs(y - h)),
            Math.min(Math.abs(x - 0), Math.abs(y - 0))
        )
    )
}