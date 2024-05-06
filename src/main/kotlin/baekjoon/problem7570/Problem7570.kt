package baekjoon.problem7570

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(n+1)
    val dp = IntArray(n+1)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        array[index+1] = i
    }
    var max = 0
    for (i in 1 .. n) {
        dp[array[i]] = dp[array[i]- 1] + 1
        max = Math.max(max, dp[array[i]])
    }
    println(n-max)
}
