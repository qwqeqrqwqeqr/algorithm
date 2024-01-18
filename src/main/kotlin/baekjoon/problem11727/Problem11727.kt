package baekjoon.problem11727

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val dp = LongArray(1001)

    dp[1] = 1;
    dp[2] = 3;

    for(i in 3 until  1001){
        dp[i]=(dp[i-2]*2+dp[i-1])%10007
    }

    println(dp[readLine().toInt()])
}

