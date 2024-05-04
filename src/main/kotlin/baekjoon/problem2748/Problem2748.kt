package baekjoon.problem2748

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val dp = LongArray(91){0}
    dp[0] = 0
    dp[1] = 1
    for(i in 2 until  dp.size){
        dp[i] = dp[i-1] +dp[i-2]
    }
    println(dp[readLine().toInt()])
}