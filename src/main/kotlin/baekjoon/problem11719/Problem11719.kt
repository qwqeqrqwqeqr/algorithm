package baekjoon.problem11719

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (true){
        val str = readLine() ?: break
        bufferedWriter.append("${str}\n")
    }
    bufferedWriter.flush()
}