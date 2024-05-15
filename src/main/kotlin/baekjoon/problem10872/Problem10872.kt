package baekjoon.problem10872

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(13) { it }
    dp[0] = 1
    for (i in 1 until 13) {
        dp[i] = dp[i] * dp[i - 1]
    }
    println(dp[n])
}