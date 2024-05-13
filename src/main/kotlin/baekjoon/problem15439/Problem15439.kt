package baekjoon.problem15439

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().toInt().let { it * (it - 1) })
}