package baekjoon.problem1000

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().split(" ").map { it.toInt() }.let { it[0]+it[1] })
}