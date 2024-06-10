package baekjoon.problem14215

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toInt() }.sorted()
    if (a + b > c) println(a + b + c)
    else println((a + b) * 2 - 1)
}