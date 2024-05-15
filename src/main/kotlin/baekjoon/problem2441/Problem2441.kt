package baekjoon.problem2441

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    for (i in 0 until n) {
        for (k in 0 until i) {
            print(" ")
        }
        for (j in i until n) {
            print("*")
        }

        println()
    }
}