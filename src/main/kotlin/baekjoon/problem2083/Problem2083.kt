package baekjoon.problem2083

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val (a, b, c) = readLine().split(" ")
        if (a == "#" && b.toInt() == 0 && c.toInt() == 0) break
        println("$a ${if (b.toInt() > 17 || c.toInt() >= 80) "Senior" else "Junior"}")
    }
}