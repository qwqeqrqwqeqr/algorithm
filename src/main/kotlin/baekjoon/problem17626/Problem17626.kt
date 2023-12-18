package baekjoon.problem17626

import kotlin.math.sqrt

var min = Int.MAX_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val dp = IntArray(50001){0}
    dp[1] =1

    for(i in 1 ..input){
        dp[i] = dp[1] + dp[i-1]
        for(j in 2 ..sqrt(i.toDouble()).toInt()){
            dp[i] = dp[i].coerceAtMost(1 + dp[i - j * j])
        }
    }
    println(dp[input])
}

