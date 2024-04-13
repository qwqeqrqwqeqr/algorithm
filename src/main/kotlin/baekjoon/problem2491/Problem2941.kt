package baekjoon.problem2491

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(n)
    val dp = IntArray(n) { 1 }
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> array[index] = i }


    for (i in 1 until n) {
        if (array[i] >= array[i - 1]) dp[i] = dp[i - 1] + 1
        else dp[i] = 1
    }
    val maxLength1 = dp.max()

    dp.fill(1)

    for (i in 1 until n) {
        if (array[i] <= array[i - 1]) dp[i] = dp[i - 1] + 1
        else dp[i] = 1
    }

    val maxLength2 = dp.max()

    println(Math.max(maxLength1,maxLength2))
}