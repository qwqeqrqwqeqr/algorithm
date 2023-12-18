package baekjoon.problem2577

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    (readLine().toInt() * readLine().toInt() * readLine().toInt()).run {
        this.toString().groupBy { it }.also { group ->
            repeat(10){
                bufferedWriter.append("${group[it.digitToChar()]?.size ?: 0}\n")
            }
        }
    }
    bufferedWriter.flush()
}