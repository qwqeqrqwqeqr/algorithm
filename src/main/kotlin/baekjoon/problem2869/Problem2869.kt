package baekjoon.problem2869

import kotlin.math.ceil
fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toDouble() }.also {
        println(ceil(((it[2]-it[0])/(it[0]-it[1]))).toInt()+1)
    }
}