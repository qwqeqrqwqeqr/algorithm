package baekjoon.problem4101

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        if (a == b && a == 0) break
        println(if (a > b) "Yes" else "No")
    }
}