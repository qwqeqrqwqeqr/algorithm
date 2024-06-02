package baekjoon.problem5598

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().map {
        when (it) {
            'A' -> 'X'
            'B' -> 'Y'
            'C' -> 'Z'
            else -> it - 3
        }
    }.joinToString(""))
}