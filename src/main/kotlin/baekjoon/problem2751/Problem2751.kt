package baekjoon.problem2751

import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val list = ArrayList<Int>()
    repeat (readLine().toInt()){ list.add(readLine().toInt()) }
    bufferedWriter.append(list.sorted().joinToString("\n"))
    bufferedWriter.flush()
}


