package baekjoon.problem16395

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,k) = readLine().split(" ").map { it.toInt() }
    val dp = Array(30) { IntArray(30) }
    for(i in 0 until 30){
        dp[i][0] =1
    }
    for (i in 1 until 30) {
        for (j in 1 until 30) {
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
        }
    }
    println(dp[n-1][k-1])
}