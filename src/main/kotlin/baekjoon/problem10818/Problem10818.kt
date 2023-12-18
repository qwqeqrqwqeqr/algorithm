package baekjoon.problem10818

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine()
    readLine().split(" ").map { it.toInt() }.also {
        println("${it.min()} ${it.max()}")
    }
}