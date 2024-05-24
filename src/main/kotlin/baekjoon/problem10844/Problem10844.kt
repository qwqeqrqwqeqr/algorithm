package baekjoon.problem10844

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(101) { LongArray(10) }

    dp[1].fill(1)

    for (i in 2 until 101) {
        for (j in 0 .. 9) {
            when (j) {
                0 -> dp[i][0] = dp[i - 1][1]
                9 -> dp[i][9] = dp[i - 1][8]
                else -> dp[i][j] = dp[i - 1][j - 1] % 1_000_000_000 + dp[i - 1][j + 1] % 1_000_000_000
            }
        }
    }
    println(dp[n].slice(1..9).sum() % 1_000_000_000)
}
