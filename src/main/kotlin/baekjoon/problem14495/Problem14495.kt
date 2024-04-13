package baekjoon.problem14495

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()

    val dp = LongArray(117)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    for (i in 4..input) {
        dp[i] = dp[i - 1] + dp[i - 3]
    }
    println(dp[input])
}