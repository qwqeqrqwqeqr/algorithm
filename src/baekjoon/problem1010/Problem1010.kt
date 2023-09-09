package baekjoon.problem1010

import kotlin.math.max


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        readLine().split(" ").map { it.toInt() }.apply {
            val dp = Array( max(this[0], this[1]) + 1) { IntArray( max(this[0], this[1]) + 1) { -1 } }
            println(combinationCount(dp, this[1], this[0]))
        }
    }
}



fun combinationCount(dp: Array<IntArray>, n: Int, r: Int): Int {
    if (r == 0 || n == r) return 1
    if (dp[n][r] == -1) dp[n][r] = combinationCount(dp, n - 1, r - 1) + combinationCount(dp, n - 1, r)
    return dp[n][r]
}

