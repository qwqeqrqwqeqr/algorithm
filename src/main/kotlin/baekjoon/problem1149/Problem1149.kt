package baekjoon.problem1149

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val array = Array(N + 1) { IntArray(3) }
    val dp = Array(N + 1) { IntArray(3) { 0 } }

    repeat(N) {
        val (r, g, b) = readLine().split(" ").map { it.toInt() }
        array[it + 1][0] = r
        array[it + 1][1] = g
        array[it + 1][2] = b
    }

    for (i in 1..N) {
        dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + array[i][0]
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + array[i][1]
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + array[i][2]
    }

    println(dp[N].min())
}


