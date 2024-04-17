package baekjoon.problem11004

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,k) = readLine().split(" ").map { it.toInt() }
    println(readLine().split(" ").map { it.toInt() }.sorted()[k-1])
}