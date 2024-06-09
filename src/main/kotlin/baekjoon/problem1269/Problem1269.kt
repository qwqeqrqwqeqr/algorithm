package baekjoon.problem1269

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val setA = readLine().split(" ").map { it.toInt() }.toSet()
    val setB = readLine().split(" ").map { it.toInt() }.toSet()
    println(setA.minus(setB).union(setB.minus(setA)).count())
}