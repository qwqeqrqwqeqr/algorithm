package baekjoon.problem2750

import java.util.LinkedList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val list = LinkedList<Int>()
    repeat(readLine().toInt()){
        list.add(readLine().toInt())
    }
    println(list.sorted().joinToString("\n"))
}