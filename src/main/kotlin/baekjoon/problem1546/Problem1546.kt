package baekjoon.problem1546

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine()
    readLine().split(" ").map { it.toDouble() }.run {
        println(map { it/max()*100 }.average())
    }
}