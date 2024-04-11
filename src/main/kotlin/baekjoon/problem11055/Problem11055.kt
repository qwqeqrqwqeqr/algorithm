package baekjoon.problem11055

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val dp = IntArray(1001)
   readLine().toInt()
    val array = IntArray(1001)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> array[index + 1] = i }
    for (i in 0 until  1001) {
        for (j in 0 until 1001) {
            if (array[i] > array[j]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + array[i])
            }
        }
    }
    println(dp.max())
}