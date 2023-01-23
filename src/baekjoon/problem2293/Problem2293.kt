package baekjoon.problem2293


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) =readLine().split(" ").map { it.toInt() }
    val coinList = Array(n+1){0}
    var dp = IntArray(100001){0}
    dp[0] = 1
    repeat(n){ coinList[it+1] = readLine().toInt() }
    for (i in 1 ..  n){
        for (j in coinList[i]..k) {
            dp[j] += dp[j - coinList[i]]
        }
    }
    println(dp[k])
}
