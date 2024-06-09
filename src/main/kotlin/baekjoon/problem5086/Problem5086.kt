package baekjoon.problem5086

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    while (true) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        if (a == b && b == 0) break
        println(
            if (a % b == 0) "multiple"
            else if (b % a == 0) "factor"
            else "neither"
        )
    }
}