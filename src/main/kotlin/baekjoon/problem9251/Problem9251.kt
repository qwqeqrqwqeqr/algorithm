package baekjoon.problem9251

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var a = readLine()
    var b = readLine()
    var length = a.length
    if (a.length > b.length) {
        length = a.length
        repeat(a.length - b.length) {
            b= b.plus('#')
        }
    } else if (b.length > a.length) {
        length = b.length
        repeat(b.length - a.length) {
           a= a.plus('#')
        }
    }
    val dp = Array(length + 1) { IntArray(length + 1) }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] != b[j - 1]) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            } else {
                dp[i][j] = dp[i - 1][j - 1] + 1
            }
        }
    }
    println(dp[length][length])
}