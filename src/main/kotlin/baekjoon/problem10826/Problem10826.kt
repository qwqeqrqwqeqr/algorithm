package baekjoon.problem10826

import java.math.BigInteger

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    when (val input = readLine().toInt()) {
        0 -> println(0)
        1 -> println(1)
        else -> {
            val dp = ArrayList<BigInteger>()
            dp.add(BigInteger("0"))
            dp.add(BigInteger("1"))

            for (i in 2..input) {
                dp.add(dp[i - 2].plus(dp[i - 1]))
            }
            println(dp[input])
        }
    }
}