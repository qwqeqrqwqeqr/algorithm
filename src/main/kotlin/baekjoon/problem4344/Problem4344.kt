package baekjoon.problem4344

import java.text.DecimalFormat

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val list = readLine().split(" ").map { it.toDouble() }.drop(1)
        val avg = list.average()
        val format = DecimalFormat("#.000%")
        println(format.format((list.count { it > avg }.toDouble() / list.size.toDouble())))
    }
}