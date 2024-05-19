package baekjoon.problem1912

import kotlin.math.max

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(100_001)
    val dp = IntArray(100_001)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        array[index + 1] = i
    }
    for (i in 1 .. n) {
        dp[i] = max(array[i], dp[i - 1] + array[i])
    }

    println(dp.slice(1 ..  n).max())
}
