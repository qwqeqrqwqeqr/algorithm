package baekjoon.problem1463

import java.lang.Integer.min


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val dp = IntArray(10_000_000) { 0 }.apply {
        this[1] = 0;this[2] = 1; this[3] = 1
    }
    readLine().toInt().apply {
        for (i in 4..this) {
            dp[i] = dp[i-1] +1
            if(i%2==0){
                dp[i] = min(dp[i],dp[i/2]+1)
            }
            if(i%3==0){
                dp[i] = min(dp[i],dp[i/3]+1)
            }
        }
        println(dp[this])
    }
}


