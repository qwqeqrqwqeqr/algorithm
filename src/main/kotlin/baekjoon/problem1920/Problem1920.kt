package baekjoon.problem1920

import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val map = HashMap<Int, Unit>()
    readLine()
    readLine().split(" ").map { map.put(it.toInt(), Unit) }
    readLine()
    readLine().split(" ").forEach {
        if(map.contains(it.toInt())) bufferedWriter.append("1\n") else bufferedWriter.append("0\n")
    }
    bufferedWriter.flush()
}