package baekjoon.problem2473

import kotlin.math.abs

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toLong() }.sorted()

    var answer = Triple(0, 1, 2)
    var sum = Long.MAX_VALUE


    for (i in 0 until n) {
        var start = i + 1
        var end = n - 1

        while (start < end) {
            val temp = list[i]+list[start] + list[end]
            if (abs(temp) < abs(sum)) {
                sum = temp
                answer = Triple(i, start, end)
            }
            if (temp > 0) end -= 1
            else if (temp < 0) start += 1
            else break
        }
    }
    answer.toList().map { list[it] }.sorted().also {
        println("${it[0]} ${it[1]} ${it[2]}")
    }
}