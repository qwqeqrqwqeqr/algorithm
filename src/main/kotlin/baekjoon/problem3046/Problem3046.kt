package baekjoon.problem3046

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a,b) = readLine().split(" ").map { it.toInt() }
    println(b*2-a)
}