package baekjoon.problem2839

import kotlin.math.min

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val dp = IntArray(5001) { Int.MAX_VALUE }.apply {
        this[0] = 0;
        this[3] = 1
        this[5] = 1
    }
    readLine().toInt().apply {
        for (i in 5..this) {
            if(i%3==0){
                dp[i] = min(dp[i],dp[i-3]+1)
            }
            if(i%5==0){
                dp[i] = min(dp[i],dp[i-5]+1)
            }
            if(dp[(i-3)]!= Int.MAX_VALUE){
                dp[i] = min(dp[i],dp[i-3]+1)
            }
            if(dp[(i-5)]!= Int.MAX_VALUE){
                dp[i] = min(dp[i],dp[i-5]+1)
            }
        }
        println(if(dp[this]==Int.MAX_VALUE) -1 else dp[this] )
    }
}