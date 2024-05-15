package baekjoon.problem2720

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(readLine().toInt()) {
        var input = readLine().toInt()
        val a = input / 2
        input %= 25
        val b = input / 10
        input %= 10
        val c = input / 5
        input %= 5
        val d = input / 1
        bufferedWriter.append("$a $b $c $d\n")
    }
    bufferedWriter.flush()
}