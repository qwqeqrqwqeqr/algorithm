package baekjoon.problem1181

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    ArrayList<String>().apply {
        repeat(readLine().toInt()) { this.add(readLine()) }
    }.also {
        it.sortedWith(compareBy<String> { it.length }.thenBy { it }).distinct()
            .forEach { bufferedWriter.append(it + "\n") }
        bufferedWriter.flush()
    }
}




