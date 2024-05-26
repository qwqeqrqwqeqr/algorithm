package baekjoon.problem2011

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine()
    val dp = LongArray(5001)
    val mod = 1_000_000
    dp[0] = 1
    dp[1] = 1
    for (i in 2..n.length) {
        if (n[i - 1] != '0') dp[i] = (dp[i] + dp[i - 1]) % mod
        if (n.slice(i - 2..<i).toInt() in 10..26)
            dp[i] = (dp[i] + dp[i - 2]) % mod
    }
    if (n[0] == '0') println(0)
    else if (n == "0") println(0)
    else println(dp[n.length])
}





