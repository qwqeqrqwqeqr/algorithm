package baekjoon.problem10250

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (H, W, N) = readLine().split(" ").map { it.toInt() }
        println("${(((N - 1) % H) + 1)}${(((N - 1) / H) + 1).let { if (it < 10) "0${it}" else it }}")
    }
}
