package baekjoon.problem10807

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    println(readLine().split(" ").map { it.toInt() }.let {
        val value = readLine().toInt()
        it.count { it == value }
    })
}