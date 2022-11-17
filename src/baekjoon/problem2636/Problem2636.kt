package baekjoon.problem2636

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)
var Y = 0
var X = 0
var visited = arrayOf(booleanArrayOf())
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }.apply { Y = this[0]; X = this[1] }
    val mapList = ArrayList<ArrayList<Int>>()
    val cheeseList = HashSet<Pair<Int, Int>>()
    val airQueue: Queue<Pair<Int, Int>> = LinkedList()
    var size = 0
    var depth = 0

    for (i in 0 until input[0]) {
        val temp = readLine().split(" ").map { it.toInt() }.toList() as ArrayList<Int>
        temp.forEachIndexed { index, j ->
            if (j == 1) {
                cheeseList.add(Pair(i, index))
            }
        }
        mapList.add(temp)
    }


    visited = Array(input[0]) { BooleanArray(input[1]) }

    initAirList(airQueue)


    while (cheeseList.isNotEmpty()) {
        size = cheeseList.size
        val tempSet = HashSet<Pair<Int, Int>>()
        while (airQueue.isNotEmpty()) {
            val target = airQueue.poll()
            if (!visited[target.first][target.second]) {
                for (i in 0 until 4) {
                    if (checkBound(target.first + dy[i], target.second + dx[i])) {
                        if (mapList[target.first + dy[i]][target.second + dx[i]] == 1) {
                            tempSet.add(Pair(target.first + dy[i], target.second + dx[i]))
                        }else{
                            airQueue.add(Pair(target.first + dy[i], target.second + dx[i]))
                        }
                    }
                }
            }
            visited[target.first][target.second] = true

        }
        tempSet.forEach {
            airQueue.add(it)
            mapList[it.first][it.second] = 0
            cheeseList.remove(it)
        }
        tempSet.clear()
        depth += 1

    }
    println(depth)
    println(size)

}

fun initAirList(queue: Queue<Pair<Int, Int>>) {
    queue.clear()
    for (i in 0 until X) {
        queue.add(Pair(0, i))
        queue.add(Pair(Y - 1, i))
    }
    for (i in 0 until Y) {
        queue.add(Pair(i, 0))
        queue.add(Pair(i, X - 1))
    }
    queue.distinct()
}

fun checkBound(y: Int, x: Int): Boolean {
    return (1 <= x && 1 <= y && x < X && y < Y)
}
