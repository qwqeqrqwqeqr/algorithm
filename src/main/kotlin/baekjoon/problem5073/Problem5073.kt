package baekjoon.problem5073

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        if (a == b && b == c && c == 0) break
        if (listOf(a, b, c).sorted().let { it[2] >= it[0] + it[1] }) println("Invalid")
        else if (a == b && b == c) println("Equilateral")
        else if (setOf(a, b, c).size == 2) println("Isosceles")
        else println("Scalene")
    }
}