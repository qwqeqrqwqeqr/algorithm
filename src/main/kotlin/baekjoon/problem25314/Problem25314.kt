package baekjoon.problem25314

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt() / 4
    repeat(n){
        bufferedWriter.append("long ")
    }
    bufferedWriter.append("int")
    bufferedWriter.flush()
}