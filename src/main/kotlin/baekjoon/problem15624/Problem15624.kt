package baekjoon.problem15624


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val dp = IntArray(1_000_001)
    dp[0] = 0
    dp[1] = 1
    for (i in 2..input) {
        dp[i] = (dp[i - 2] + dp[i - 1]).mod(1000000007)
    }
    println(dp[input])
}
