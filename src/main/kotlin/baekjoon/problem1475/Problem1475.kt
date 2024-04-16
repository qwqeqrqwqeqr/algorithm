package baekjoon.problem1475

import kotlin.math.roundToInt

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = HashMap<Int, Int>()
    readLine().forEach {
        it.digitToInt().also { n ->
            val num = if (n == 6 || n == 9) -1 else n
            map[num] = map.getOrDefault(num, 0) + 1
        }
    }
    map[-1] = (map.getOrDefault(-1, 0).toDouble() / 2).roundToInt()
    println(map.maxOf { it.value })
}