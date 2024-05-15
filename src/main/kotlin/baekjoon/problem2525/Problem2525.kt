package baekjoon.problem2525

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var (a, b) = readLine().split(" ").map { it.toInt() }
    b += readLine().toInt()
    a += b / 60
    println("${a%24} ${b%60}")
}