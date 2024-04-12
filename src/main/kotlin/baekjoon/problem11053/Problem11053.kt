package baekjoon.problem11053

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val size = readLine().toInt()
    val array = IntArray(1001) { 0 }
    val dp = IntArray(1001) { 1 }
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> array[index] = i }


    for (i in 0 until size) {
        for (j in 0 until i) {
            if(array[i] > array[j])
                dp[i] = Math.max(dp[j]+1,dp[i])
        }
    }
    println(dp.max())
}
