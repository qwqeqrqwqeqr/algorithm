package baekjoon.problem2675

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(readLine().toInt()){
        val value = readLine().split(" ").let { Pair(it[0].toInt(),it[1]) }

        value.second.forEach { text ->
            repeat(value.first){ bufferedWriter.append("${text}") }
        }
        bufferedWriter.append("\n")
    }
    bufferedWriter.flush()
}

