package baekjoon.problem1009

import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    val array = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(6, 2, 4, 8),
        intArrayOf(1, 3, 9, 7),
        intArrayOf(6, 4, 6, 4),
        intArrayOf(5, 5, 5, 5),
        intArrayOf(6, 6, 6, 6),
        intArrayOf(1, 7, 9, 3),
        intArrayOf(6, 8, 4, 2),
        intArrayOf(1, 9, 1, 9),
    )

    repeat(readLine().toInt()) {
        readLine().split(" ").map { it.toInt() }.run {
            bufferedWriter.append("${(array[this[0]%10][this[1] % 4]).let { if(it==0) 10 else it }}\n")
        }
    }
    bufferedWriter.flush()
}

