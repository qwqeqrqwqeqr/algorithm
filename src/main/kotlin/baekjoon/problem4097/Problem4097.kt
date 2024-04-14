package baekjoon.problem4097

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val input = readLine().toInt()
        if (input == 0) break
        val dp = IntArray(input)
        repeat(input) { dp[it] = readLine().toInt() }

        for (i in 1 until input) {
            dp[i] = Math.max(dp[i], dp[i] + dp[i - 1])
        }
        println(dp.max())
    }
}