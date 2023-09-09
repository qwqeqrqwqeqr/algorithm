package baekjoon.problem11726


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val dp = IntArray(1001) { 0 }.apply {
        this[1] = 1
        this[2] = 2
    }

    readLine().toInt().apply {
        for (i in 3..this) {
            dp[i] =(dp[i-1] + dp[i-2]) % 10_007
        }
        println(dp[this])
    }
}