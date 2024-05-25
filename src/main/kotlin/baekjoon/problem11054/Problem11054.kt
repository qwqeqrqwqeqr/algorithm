package baekjoon.problem11054

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(n)
    val dp = IntArray(n) { 1 }
    val queue: Queue<Int> = LinkedList()

    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        array[index] = i
    }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (array[i] > array[j]) {
                dp[i] = Math.max(dp[j] + 1, dp[i])
            }
        }
    }
    println(dp.max())
    var max = dp.max()

    for (i in n - 1 downTo 0) {
        if (max == dp[i]) {
            queue.add(array[i])
            max -= 1
        }
    }
    println(queue.reversed().joinToString(" "))
}