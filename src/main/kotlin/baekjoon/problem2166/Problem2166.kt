package baekjoon.problem2166

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array<Pair<Double, Double>>(n) { 0.0 to 0.0 }
    var sum = 0.0
    repeat(n) {
        val (x, y) = readLine().split(" ").map { it.toDouble() }
        array[it] = x to y
    }

    for (i in 1 until n) {
        sum += ccw(array[0], array[i - 1], array[i])
    }
    println(DecimalFormat("#.0").also { it.roundingMode =RoundingMode.HALF_UP }.format(abs(sum)))
}


fun ccw(a: Pair<Double, Double>, b: Pair<Double, Double>, c: Pair<Double, Double>): Double =
    ((a.first * b.second) + (b.first * c.second) + (c.first * a.second) - (b.first * a.second) - (c.first * b.second) - (a.first * c.second)) / 2


