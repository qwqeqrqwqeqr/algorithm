package baekjoon.problem1620

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val indexMap = HashMap<Int, String>()
    val nameMap = HashMap<String, Int>()
    readLine().split(" ").map { it.toInt() }.apply {
        repeat(this[0]) {
            readLine().apply {
                indexMap[it + 1] = this
                nameMap[this] = it + 1
            }
        }
        repeat(this[1]) {
            readLine().apply {
                if (typeCheck(this)) {
                    bufferedWriter.append("${nameMap[this]}\n")
                } else {
                    bufferedWriter.append("${indexMap[this.toInt()]}\n")
                }
            }
        }
    }
    bufferedWriter.flush()
}

fun typeCheck(str: String): Boolean {
    return str.none { it.toInt() in 48..57 }
}