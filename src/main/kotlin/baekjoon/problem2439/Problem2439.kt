package baekjoon.problem2439

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    readLine().toInt().run {
        repeat(this) {
            repeat(this-it-1) {
                bufferedWriter.append(" ")
            }
            repeat(it+1) {
                bufferedWriter.append("*")
            }
            bufferedWriter.append("\n")
        }
        bufferedWriter.flush()
    }
}