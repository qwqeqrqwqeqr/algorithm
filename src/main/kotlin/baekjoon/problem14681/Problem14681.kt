package baekjoon.problem14681

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val x = readLine().toInt()
    val y = readLine().toInt()
    if (x > 0 && y > 0) println(1)
    if (x > 0 && y < 0) println(4)
    if (x < 0 && y > 0) println(2)
    if (x < 0 && y < 0) println(3)
}