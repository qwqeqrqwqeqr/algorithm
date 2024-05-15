package baekjoon.problem10516

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (k, n, m) = readLine().split(" ").map { it.toInt() }
    println((k * n - m).let { if (it < 0) 0 else it })
}