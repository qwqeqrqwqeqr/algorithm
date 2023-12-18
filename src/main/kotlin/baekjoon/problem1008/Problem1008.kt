package baekjoon.problem1008

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().split(" ").map { it.toDouble() }.let { it[0]/it[1] })
}