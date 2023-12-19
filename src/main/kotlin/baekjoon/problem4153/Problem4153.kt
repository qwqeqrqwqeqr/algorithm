package baekjoon.problem4153

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.pow

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val input = readLine().split(" ").map { it.toInt() }
        if (input[0] == 0 && input[1] == 0 && input[2] == 0) break
        input.map { it.toDouble().pow(2.0) }.run {
            if (this[0] + this[1] == this[2] || this[0] + this[2] == this[1] || this[1] + this[2] == this[0])
                bufferedWriter.append("right\n")
            else bufferedWriter.append("wrong\n")
        }
    }
    bufferedWriter.flush()
}