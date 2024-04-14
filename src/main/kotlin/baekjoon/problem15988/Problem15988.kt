package baekjoon.problem15988

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val dp = LongArray(1_000_001)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4..1_000_000) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009
    }
    repeat(readLine().toInt()) {
        println(dp[readLine().toInt()])
    }
}


/**
 * 1  1 -> 1
 * 2  1 1 / 2 -> 2
 * 3  1 1 1 / 1 2 / 2 1 / 3  -> 4
 * 4  1 1 1 1 / 1 1 2 / 1 2 1 / 2 1 1 / 2 2 / 1 3 / 3 1 -> 7
 * 5
 */