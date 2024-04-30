package baekjoon.problem2589

import java.util.LinkedList
import java.util.Queue

var L = 0
var W = 0

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)
var max = Int.MIN_VALUE

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (l, w) = readLine().split(" ").map { it.toInt() }.also {
        L = it[0]
        W = it[1]
    }
    val map = Array(l) { CharArray(w) }
    val visited = Array(l) { BooleanArray(w) { false } }
    val queue: Queue<Route> = LinkedList()

    repeat(l) { row ->
        readLine().forEachIndexed { column, value ->
            map[row][column] = value
        }
    }

    for (i in 0 until l) {
        for (j in 0 until w) {
            if (map[i][j] == 'L') {

                visited.forEach { it.fill(false) }
                queue.add(Route(i, j, 0))
                visited[i][j] = true

                while (queue.isNotEmpty()) {
                    val item = queue.poll()
                    max = Math.max(item.depth, max)
                    for (k in 0..3) {
                        val target = item.y + dy[k] to item.x + dx[k]
                        if (checkBound(target.first, target.second)) {
                            if (map[target.first][target.second] == 'L' && !visited[target.first][target.second]) {
                                queue.add(Route(target.first, target.second, item.depth + 1))
                                visited[target.first][target.second] = true
                            }
                        }
                    }
                }
            }
        }
    }
    println(max)
}

data class Route(val y: Int, val x: Int, val depth: Int)

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < W && y < L)
}
