package baekjoon.problem2822

import java.util.ArrayList

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val arrayList = ArrayList<Pair<Int, Int>>()
    repeat(8) {
        arrayList.add(it + 1 to readLine().toInt())
    }
    arrayList.sortedByDescending { it.second }.take(5).sortedBy { it.first }.also {
        println(it.sumOf { it.second })
        println(it.map { it.first }.joinToString(" "))
    }
}