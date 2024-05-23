package baekjoon.problem1174

import kotlin.collections.HashSet

val set: HashSet<Long> = HashSet()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    backTracking(0, 9)

    if (n > 1023) println(-1)
    else println(set.sorted()[n - 1])
}

fun backTracking(value: Long, depth: Int) {

    set.add(value)

    if (depth < 0) return
    if (value.toString().length == 10) return


    backTracking((value * 10) + depth, depth - 1)
    backTracking(value, depth - 1)
}