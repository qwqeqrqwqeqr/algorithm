package baekjoon.problem1051

import kotlin.math.pow

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(m) }
    val start = Math.min(n, m)
    repeat(n) { row ->
        readLine().map { it.digitToInt() }.forEachIndexed { column, value ->
            array[row][column] = value
        }
    }

    for (i in start downTo 1) {
        for (j in 0..n - i) {
            for (k in 0..m - i) {
                if (setOf(array[j][k], array[j + i-1][k], array[j][k + i-1], array[j + i-1][k + i-1]).size == 1) {
                    println(i.toDouble().pow(2).toInt())
                    return@with
                }
            }
        }
    }
}