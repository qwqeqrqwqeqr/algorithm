package baekjoon.problem9252

import java.util.LinkedList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var a = readLine()
    var b = readLine()
    if (a.length > b.length) {
        repeat(a.length - b.length) {
            b = b.plus('#')
        }
    } else if (b.length > a.length) {
        repeat(b.length - a.length) {
            a = a.plus('#')
        }
    }
    var n = a.length
    val dp = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        for (j in 1..n) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    println(dp[n][n])
    val list = LinkedList<Char>()

    if (dp[n][n] != 0) {
        var row = n
        var column = n
        while (row != 0 && column != 0) {
            if (a[row - 1] == b[column - 1]) {
                list.add(a[row - 1])
                row--;
                column--
            } else {
                if (dp[row][column] == dp[row - 1][column]) row--
                else if (dp[row][column] == dp[row][column - 1]) column--
            }
        }
        println(list.reversed().joinToString(""))
    }
}

