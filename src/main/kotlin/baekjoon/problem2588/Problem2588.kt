package baekjoon.problem2588

import kotlin.math.pow

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var sum = 0
    readLine().reversed().forEachIndexed { index, it->
        val mul =n*it.digitToInt()
        println(mul)
        sum+=mul*(10.0.pow(index).toInt())
    }
    println(sum)
}