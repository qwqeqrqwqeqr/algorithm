package baekjoon.problem10952

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val value = readLine().split(" ").map { it.toInt() }
        if (value[0] == 0 && value[1] == 0) break
        println(value[0] + value[1])
    }
}