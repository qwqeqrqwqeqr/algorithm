package baekjoon.problem25304

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val x = readLine().toInt()
    var sum = 0
    repeat(readLine().toInt()) {
        sum += readLine().split(" ").map { it.toInt() }.let { it[0] * it[1] }
    }
    println(if (sum == x) "Yes" else "No")
}