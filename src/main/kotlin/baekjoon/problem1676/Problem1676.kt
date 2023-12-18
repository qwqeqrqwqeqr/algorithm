package baekjoon.problem1676

import kotlin.math.min

var two = 0
var five = 0
fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().toInt().apply {
        count(this)
        println(min(five,two))
    }
}

fun count(n: Int) {
    for (i in 1..n) {
        var temp2 = i
        var temp5 = i
        while (temp2 % 2 == 0) {
            temp2 /= 2
            two += 1
        }
        while (temp5 % 5 == 0) {
            temp5 /= 5
            five += 1
        }
    }
}

