package baekjoon.problem13699

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val dp = LongArray(36)
    dp[0] = 1
    for (i in 1..input) {
        var sum = 0L
        for (j in 0 until i) {
            sum += dp[j] * dp[i - j - 1]
        }
        dp[i] = sum
    }
    println(dp[input])
}
