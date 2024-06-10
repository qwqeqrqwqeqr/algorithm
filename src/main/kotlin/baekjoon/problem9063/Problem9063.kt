package baekjoon.problem9063

import java.util.LinkedList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val xList = LinkedList<Int>()
    val yList = LinkedList<Int>()
    repeat(readLine().toInt()) {
        readLine().split(" ").also {
            xList.add(it[0].toInt())
            yList.add(it[1].toInt())
        }
    }
    println((xList.max() - xList.min()) * (yList.max() - yList.min()))
}