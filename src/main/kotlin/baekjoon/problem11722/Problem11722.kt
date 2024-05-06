package baekjoon.problem11722


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(n)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        array[index] = i
    }
    val dp = IntArray(n)

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (array[i] < array[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1)
            }
        }
    }
    println(dp.max() + 1)
}
