package baekjoon.problem2903

import kotlin.math.pow

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val dp = IntArray(16);dp[1] = 3
    for (i in 2 until dp.size) {
        dp[i] = dp[i - 1] * 2 - 1
    }
    println(dp[readLine().toInt()].toDouble().pow(2.0).toInt())
}
