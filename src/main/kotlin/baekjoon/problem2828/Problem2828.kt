package baekjoon.problem2828

import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val j = readLine().toInt()

    val array = IntArray(j)
    repeat(j) { array[it] = readLine().toInt() -1 }

    var left = 0
    var right = (m-1)
    var count = 0

    for (i in array.indices) {
        if (array[i] in left..right) {
            continue
        } else if (abs(array[i] - left) < abs(array[i] - right)) {
            count += abs(array[i] - left)
            left = array[i]
            right = left + (m-1)
        } else {
            count += abs(array[i] - right)
            right = array[i]
            left = right - (m-1)
        }
    }
    println(count)
}