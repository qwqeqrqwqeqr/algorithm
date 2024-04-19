package baekjoon.problem1343

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var input = readLine()
    input= input.replace("XXXX", "AAAA")
    input= input.replace("XX", "BB")
    println(if (input.any { it == 'X' }) -1 else input)
}