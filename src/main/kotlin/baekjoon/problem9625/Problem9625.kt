package baekjoon.problem9625

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()

    val dp = ArrayList<Pair<Int, Int>>()
    dp.add(1 to 0)
    dp.add(0 to 1)

    for (i in 2..input) {
        dp.add(
            dp[i - 1].first + dp[i - 2].first to dp[i - 1].second + dp[i - 2].second
        )
    }
    dp[input].apply {
        println("$first $second")
    }
}

/**
 * 0    a
 * 1    b
 * 2    ba
 * 3    bab
 * 4    babba
 */