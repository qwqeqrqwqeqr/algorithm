package baekjoon.problem11048

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n + 1) { IntArray(m + 1) }
    val dp = Array(n + 1) { IntArray(m + 1) }
    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            map[row + 1][column + 1] = value
        }
    }
    for (i in 1 .. n) {
        for (j in 1 .. m) {
            dp[i][j] = map[i][j] + Math.max(Math.max(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j])
        }
    }
    println(dp[n][m])
}