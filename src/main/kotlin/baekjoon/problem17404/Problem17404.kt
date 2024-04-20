package baekjoon.problem17404

const val INF = 1_000_000
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }
    var min = Int.MAX_VALUE

    repeat(n) {
        val (r, g, b) = readLine().split(" ").map { it.toInt() }
        array[it][0] = r
        array[it][1] = g
        array[it][2] = b
    }

    for (i in 0..2) {
        dp[0].fill(INF)
        dp[0][i] = array[0][i]

        for (j in 1 until n) {
            dp[j][0] = array[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2])
            dp[j][1] = array[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2])
            dp[j][2] = array[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1])
        }

        for (k in 0..2) {
            if (k != i) min = Math.min(dp[n - 1][k], min)
        }
    }
    println(min)
}

