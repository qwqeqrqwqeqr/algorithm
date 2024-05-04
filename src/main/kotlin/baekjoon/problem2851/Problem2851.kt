package baekjoon.problem2851

import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = ArrayList<Pair<Int, Int>>()
    repeat(10) {
        if (array.isNotEmpty()) (array.last().first + readLine().toInt()).apply {
            array.add(this to this - 100)
        }
        else readLine().toInt().apply { array.add(this to this - 100) }
    }
    print(array.sortedWith(comparator = compareBy<Pair<Int, Int>> { abs(it.second) }.thenComparing(compareByDescending { it.second })).first().first)
}


