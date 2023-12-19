package baekjoon.problem11720

fun main(args: Array<String>) = with(System.`in`.bufferedReader()){
    readLine()
    println(readLine().map { it.digitToInt() }.sum())
}