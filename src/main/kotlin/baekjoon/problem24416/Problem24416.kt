package baekjoon.problem24416

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(41)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 1
    for (i in 3..40) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println("${dp[n]} ${n-2}")
}
