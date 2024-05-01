package baekjoon.problem2239

import kotlin.system.exitProcess


val map = Array(9) { IntArray(9) }
val emptyList: ArrayList<Pair<Int, Int>> = ArrayList()
var maxDepth = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {


    repeat(9) { row ->
        readLine().forEachIndexed { column, value ->
            map[row][column] = value.digitToInt()
            if (value.digitToInt() == 0) emptyList.add(row to column)
        }
    }
    maxDepth = emptyList.size
    backTracking(0)
}


fun backTracking(depth: Int) {
    if (maxDepth == depth) {
        map.forEach {
            println(it.joinToString(""))
        }
        exitProcess(0)
    }
    val item = emptyList[depth]
    for (n in 0..9) {
        if (check(item, n)) {
            map[item.first][item.second] = n
            backTracking(depth + 1)
            map[item.first][item.second] = 0
        }
    }
}

fun check(item: Pair<Int, Int>, n: Int): Boolean {
    for (i in 0..8) {
        if (map[i][item.second] == n) return false
        if (map[item.first][i] == n) return false
    }
    val targetY = (item.first / 3) * 3
    val targetX = (item.second / 3) * 3

    for (i in 0 until 3) {
        for (j in 0 until 3){
            if(map[i+targetY][j+targetX]==n)
                return false
        }
    }
    return true
}

