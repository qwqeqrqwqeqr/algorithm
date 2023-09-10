package baekjoon.problem17219

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, String>()
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(input[0]) {
        readLine().split(" ").apply {
            map[this[0]] = this[1]
        }
    }
    repeat(input[1]) { bufferedWriter.append("${map[readLine()]}\n") }
    bufferedWriter.flush()
}