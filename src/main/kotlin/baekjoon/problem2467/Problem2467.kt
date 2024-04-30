package baekjoon.problem2467

import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    var start = 0
    var end = n - 1

    var target = Int.MAX_VALUE
    var answer = start to end


    while (start < end) {
        val sum = list[start] + list[end]
        if (abs(sum) < abs(target)) {
            target = sum
            answer = start to end
        }
        if (sum > 0) end -= 1
        else if (sum < 0) start += 1
        else break
    }

    println("${list[answer.first]} ${list[answer.second]}")
}