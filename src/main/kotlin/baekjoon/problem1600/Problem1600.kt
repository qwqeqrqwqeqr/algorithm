package baekjoon.problem1600

import java.util.*


var W = 0
var H = 0
var K = 0
var min = Int.MAX_VALUE
val dy = intArrayOf(0, 0, -1, 1)
val dx = intArrayOf(-1, 1, 0, 0)

val ndy = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)
val ndx = intArrayOf(-2, -1, 1, 2, -2, -1, 1, 2)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    K = readLine().toInt()
    readLine().split(" ").map { it.toInt() }.also {
        W = it[0]; H = it[1]
    }
    val map = Array(H) { IntArray(W) }
    repeat(H) { r ->
        readLine().split(" ").forEachIndexed { c, value ->
            map[r][c] = value.toInt()
        }
    }

    bfs(map)
    println(if (min == Int.MAX_VALUE) -1 else min)
}

fun bfs(map: Array<IntArray>) {
    val queue: Queue<Distance> = LinkedList()
    queue.add(Distance(0, 0, 0, K))
    val visited = Array(H) { Array(W) { BooleanArray(31) { false } } }

    while (queue.isNotEmpty()) {
        val item = queue.poll()
        if (item.y == H - 1 && item.x == W - 1) {
            min = min.coerceAtMost(item.distance)
        }
        if (!visited[item.y][item.x][item.k]) {
            visited[item.y][item.x][item.k] = true

            for (i in 0 until 4) {
                if (checkBound(item.y + dy[i], item.x + dx[i]) &&
                    !visited[item.y + dy[i]][item.x + dx[i]][item.k] &&
                    map[item.y + dy[i]][item.x + dx[i]] == 0
                ) queue.add(Distance(item.y + dy[i], item.x + dx[i], item.distance + 1, item.k))
            }
            if (item.k > 0) {
                for (i in 0 until 8) {
                    if (checkBound(item.y + ndy[i], item.x + ndx[i]) &&
                        !visited[item.y + ndy[i]][item.x + ndx[i]][item.k] &&
                        map[item.y + ndy[i]][item.x + ndx[i]] == 0
                    ) queue.add(Distance(item.y + ndy[i], item.x + ndx[i], item.distance + 1, item.k - 1))
                }
            }
        }
    }
}


data class Distance(val y: Int, val x: Int, val distance: Int, val k: Int)


fun checkBound(y: Int, x: Int): Boolean =(0 <= x && 0 <= y && x < W && y < H)


