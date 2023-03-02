package baekjoon.problem1181

import java.io.BufferedWriter
import java.io.OutputStreamWriter
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val list = ArrayList<String>()
    repeat(readLine().toInt()) {
        list.add(readLine())
    }.run {
        list.sortedWith(compareBy<String> { it.length }.thenBy { it }).distinct()
            .forEach { bufferedWriter.append(it + "\n") }.run {
            bufferedWriter.flush()
        }
    }
}




