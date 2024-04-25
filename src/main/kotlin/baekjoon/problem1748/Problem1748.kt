package baekjoon.problem1748

import kotlin.math.pow

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toLong()
    var sum = 0L

    for (i in 1 until input.toString().length) {
        sum += (i * 9 * 10.0.pow(i-1)).toLong()
    }
    sum +=(input-10.0.pow(input.toString().length-1).toInt()+1)*input.toString().length
    println(sum)
}

/**
 *  1 ~ 9  => 1 * 9  => 9
 *  1 ~ 99 => 1*9 + 2* 90 => 189
 *  1 ~ 999 => 1 * 9 + 2* 90 + 3 * 900 => 2889
 */
