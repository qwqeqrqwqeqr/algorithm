package baekjoon.problem14442

import java.util.LinkedList
import java.util.Queue


var N = 0
var M = 0
var K = 0
var min = Int.MAX_VALUE
val wallList = LinkedList<Pair<Int, Int>>()
val dy = intArrayOf(0, 0, -1, 1)
val dx = intArrayOf(-1, 1, 0, 0)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    N = n; M = m; K = k
    val array = Array(n) { IntArray(m) }

    repeat(n) { r ->
        readLine().forEachIndexed { c, value ->
            array[r][c] = value.digitToInt()
            if (value == '1') wallList.add(r to c)
        }
    }
    bfs(array)

    println(if (min == Int.MAX_VALUE) -1 else min)
}


fun bfs(array: Array<IntArray>) {
    val queue: Queue<Distance> = LinkedList()
    if (array[0][0] == 1 && K == 0) return
    else if (array[0][0] == 1 && K > 0) K -= 1
    queue.add(Distance(0, 0, 1, K))

    val visited = Array(N) { Array(M) { BooleanArray(K+1) {false} } }


    while (queue.isNotEmpty()) {
        val item = queue.poll()
        if (item.y == N - 1 && item.x == M - 1) {
            min = min.coerceAtMost(item.distance)
        }
        if (!visited[item.y][item.x][item.crash]) {
            visited[item.y][item.x][item.crash] = true

            for (i in 0 until 4) {
                if (checkBound(item.y + dy[i], item.x + dx[i]) &&
                    !visited[item.y + dy[i]][item.x + dx[i]][item.crash]
                ) {
                    if (array[item.y + dy[i]][item.x + dx[i]] == 0) {
                        queue.add(Distance(item.y + dy[i], item.x + dx[i], item.distance + 1, item.crash))
                    }
                    else if (array[item.y + dy[i]][item.x + dx[i]] == 1 && item.crash > 0) {
                        queue.add(Distance(item.y + dy[i], item.x + dx[i], item.distance + 1, item.crash - 1))
                    }
                }
            }
        }
    }
}

data class Distance(val y: Int, val x: Int, val distance: Int, val crash: Int)

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < M && y < N)
}


/**
 * TODO 시간초과
 * var N = 0
 * var M = 0
 * var K = 0
 * var min = Int.MAX_VALUE
 * val wallList = LinkedList<Pair<Int, Int>>()
 * val dy = intArrayOf(-1, 0, 1, 0)
 * val dx = intArrayOf(0, 1, 0, -1)
 *
 * fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
 *     val (n, m, k) = readLine().split(" ").map { it.toInt() }
 *     N = n; M = m; K = k
 *     val array = Array(n) { IntArray(m) }
 *
 *     repeat(n) { r ->
 *         readLine().forEachIndexed { c, value ->
 *             array[r][c] = value.digitToInt()
 *             if (value == '1') wallList.add(r to c)
 *         }
 *     }
 *     dfs(0, 0, array)
 *     println(if(min==Int.MAX_VALUE) -1 else min)
 * }
 *
 * fun dfs(start: Int, depth: Int, array: Array<IntArray>) {
 *     if (K == depth) {
 *         bfs(array)
 *         return
 *     }
 *     for (i in start until wallList.size) {
 *         wallList[i].also { array[it.first][it.second] = 0 }
 *         dfs(start + 1, depth + 1, array)
 *         wallList[i].also { array[it.first][it.second] = 1 }
 *     }
 * }
 *
 * fun bfs(array: Array<IntArray>) {
 *     val visited = Array(N) { BooleanArray(M) { false } }
 *     val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
 *     if (array[0][0] == 1) return
 *     queue.add(Triple(0, 0, 1))
 *
 *     while (queue.isNotEmpty()) {
 *         val item = queue.poll()
 *         if (item.first == N - 1 && item.second == M - 1) {
 *             min = min.coerceAtMost(item.third)
 *         }
 *         if (!visited[item.first][item.second]) {
 *             visited[item.first][item.second] = true
 *
 *             for (i in 0 until 4) {
 *                 if (checkBound(item.first + dy[i], item.second + dx[i]) &&
 *                     !visited[item.first + dy[i]][item.second + dx[i]] &&
 *                     array[item.first + dy[i]][item.second + dx[i]] == 0
 *                 )
 *                     queue.add(Triple(item.first + dy[i], item.second + dx[i], item.third + 1))
 *             }
 *         }
 *     }
 * }
 *
 *
 * fun checkBound(y: Int, x: Int): Boolean {
 *     return (0 <= x && 0 <= y && x < M && y < N)
 * }
 */