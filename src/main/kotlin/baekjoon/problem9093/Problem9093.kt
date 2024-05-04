package baekjoon.problem9093

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()){
        bufferedWriter.append("${readLine().split(" ").map { it.reversed() }.joinToString(" ")}\n")
    }
    bufferedWriter.flush()
}