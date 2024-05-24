package baekjoon.problem13301

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n= readLine().toInt()
    val dp = LongArray(81)
    dp[1] =1
    dp[2] =1

    if(n==1) println(4)
    else if(n==2) println(6)
    else {
        for (i in 3..80) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        println((dp[n - 1] + dp[n - 2]) * 2 + (dp[n - 1] + dp[n]) * 2)
    }
}