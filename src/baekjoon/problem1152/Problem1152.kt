package baekjoon.problem1152

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().split(" ").count { it != "" })
}