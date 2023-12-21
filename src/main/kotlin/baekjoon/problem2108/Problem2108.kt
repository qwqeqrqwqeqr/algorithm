package baekjoon.problem2108

import kotlin.math.roundToInt

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val list = ArrayList<Int>()
    repeat(readLine().toInt()) { list.add(readLine().toInt()) }
    val group = list.groupBy { it }
    println(list.map { it.toDouble() }.average().roundToInt())
    println(list.sorted()[(list.size / 2)])
    if (group.count { it.value.size == group.map { it.value.size }.max() } > 1) {
        println( group.filter { it.value.size == group.map { it.value.size }.max() }.map { Pair(it.key,it.value.size) }.sortedBy { it.first }[1].first)
    }else{
        println(group.filter { it.value.size == group.map { it.value.size }.max()}.map { Pair(it.key,it.value.size) }.sortedBy { it.first }[0].first)
    }
    println((list.max() - list.min()))
}