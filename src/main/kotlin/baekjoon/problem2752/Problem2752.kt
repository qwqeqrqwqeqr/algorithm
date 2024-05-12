package baekjoon.problem2752

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().split(" ").map { it.toInt() }.sorted().joinToString(" "))
}