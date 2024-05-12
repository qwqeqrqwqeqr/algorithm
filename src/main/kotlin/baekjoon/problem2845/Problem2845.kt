package baekjoon.problem2845

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (l,p) = readLine().split(" ").map { it.toInt() }
    println(readLine().split(" ").map {  it.toInt() -(l*p) }.joinToString(" "))
}