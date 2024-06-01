package baekjoon.problem10870

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val dp = IntArray(21) { it }
    for(i in 2 until dp.size){
        dp[i] = dp[i-1] +dp[i-2]
    }
    println(dp[readLine().toInt()])
}