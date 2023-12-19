package baekjoon.problem10869

import java.io.BufferedWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter: BufferedWriter = System.out.bufferedWriter()
    val (A, B) = readLine().split(" ").map { it.toInt() }
    bufferedWriter.append("${A + B}\n${A - B}\n${A * B}\n${A / B}\n${A % B}")
     bufferedWriter.flush()
}