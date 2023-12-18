package baekjoon.problem2475

import kotlin.math.pow

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toDouble() }.fold(0.0) { acc, s -> acc+ s.pow(2) }.apply {
        println((this.toInt()%10))
    }
}