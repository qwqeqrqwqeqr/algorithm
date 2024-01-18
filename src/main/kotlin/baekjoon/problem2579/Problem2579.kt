package baekjoon.problem2579

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val step = IntArray(301)
    val dp = IntArray(301)
    val N = readLine().toInt()

    repeat(N) { step[it+1] = readLine().toInt() }

    dp[1] = step[1]
    dp[2] = step[1] + step[2]
    dp[3] = step[3] + step[1].coerceAtLeast(step[2])

    for (i in 4 until 301) {
        dp[i] = step[i] + Math.max(step[i - 1] + dp[i - 3],dp[i - 2])
    }
    println(dp[N])
}

