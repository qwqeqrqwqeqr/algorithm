package baekjoon.problem1904

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val dp = IntArray(1_000_001) { 0 }
    dp[1] = 1
    dp[2] = 2
    for (i in 3 until  dp.size) {
        dp[i] = (dp[i - 1] % 15746 + dp[i - 2] % 15746) % 15746
    }
    println(dp[input])
}


/**
 * 1 -> 1 ->1
 * 2-> 00, 11 ->2
 * 3-> 001, 111, 100 ->3
 * 4 -> 0000,0011,1001,1100,1111 ->5
 * 5 -> 00100, 11100, 10000, 00001, 00111,  11001, 11111 ,10011 -> 8
 */