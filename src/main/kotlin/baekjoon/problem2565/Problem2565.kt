package baekjoon.problem2565

import java.util.LinkedList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val linkedList = LinkedList<Pair<Int, Int>>()
    val dp = IntArray(n) { 1 }
    repeat(n) {
        readLine().split(" ").map { it.toInt() }.also {
            linkedList.add(it[0] to it[1])
        }
    }
    linkedList.sortBy { it.first }


    for (i in 0 until n) {
        for (j in 0 until i) {
            if (linkedList[i].second > linkedList[j].second) {
                dp[i] = Math.max(dp[j] + 1, dp[i])
            }
        }
    }
    println(n-dp.max())
}