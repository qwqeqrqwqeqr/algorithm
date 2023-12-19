package baekjoon.problem2753

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().toInt().let { if (it % 4 == 0 && it % 100 != 0 || it % 400 == 0) 1 else 0 })
}
