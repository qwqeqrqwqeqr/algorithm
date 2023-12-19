package baekjoon.problem10998

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().split(" ").map { it.toInt() }.reduce { acc, i -> acc*i })
}