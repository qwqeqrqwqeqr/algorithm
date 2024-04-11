package baekjoon.problem5525

import java.lang.StringBuilder

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val S = readLine().toInt()
    val string = readLine()
    val ioi = builderIOI(N)
    var count = 0
    var cursor = 0

    while (cursor <= (S - ioi.length)) {
        if (string.slice(cursor..<cursor + ioi.length) == ioi) count += 1
        cursor +=1
    }
    println(count)
}


fun builderIOI(n: Int): String =
    StringBuilder().apply {
        repeat(n + 1) { append("IO") }
        deleteCharAt(lastIndex)
    }.toString()
