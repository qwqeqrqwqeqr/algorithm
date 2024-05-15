package baekjoon.problem10953

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()){
        val (a,b) = readLine().split(",").map { it.toInt() }
        bufferedWriter.append("${a+b}\n")
    }
    bufferedWriter.flush()
}