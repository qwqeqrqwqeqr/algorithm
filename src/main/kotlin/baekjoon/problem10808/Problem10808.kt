package baekjoon.problem10808

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().also { string ->
        println(('a'..'z').map { string.count { c -> c == it } }.joinToString(" "))
    }
}