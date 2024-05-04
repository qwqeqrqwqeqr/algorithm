package baekjoon.problem1037

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().toInt()
    readLine().split(" ").map { it.toLong() }.also {
        println(it.max()*it.min())
    }
}