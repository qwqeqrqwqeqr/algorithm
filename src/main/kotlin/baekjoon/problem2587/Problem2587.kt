package baekjoon.problem2587

import java.util.LinkedList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val list = LinkedList<Int>()
    repeat(5) { list.add(readLine().toInt()) }
    println(list.average().toInt())
    println(list.sorted()[2])
}