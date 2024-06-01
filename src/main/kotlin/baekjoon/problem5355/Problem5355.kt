package baekjoon.problem5355

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.text.DecimalFormat

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        val input = readLine().split(" ")
        var value = input[0].toFloat()
        for (i in 1 until input.size) {
            when (input[i]) {
                "@" -> value *= 3
                "%" -> value += 5
                else -> value -= 7
            }
        }
        bufferedWriter.append("${DecimalFormat("#.00").format(value)}\n")
    }
    bufferedWriter.flush()
}