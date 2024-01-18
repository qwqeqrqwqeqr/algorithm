package baekjoon.problem9461


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val dp = LongArray(101);

    dp[1]=1L;
    dp[2]=1L;
    dp[3]=1L;
    for(i in 4 until  101){
        dp[i] = dp[i-2]+dp[i-3]
    }
    repeat(readLine().toInt()){
        println(dp[readLine().toInt()])
    }
}