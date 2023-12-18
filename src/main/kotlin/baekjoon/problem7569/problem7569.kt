package baekjoon.problem7569

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.ArrayList


val dx = intArrayOf(0, 1, 0, -1, 0, 0)
val dy = intArrayOf(-1, 0, 1, 0, 0, 0)
val dz = intArrayOf(0, 0, 0, 0, -1, 1)
var M: Int = 0
var N: Int = 0
var H: Int = 0
var depth = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply {
        M = this[0];N = this[1];H = this[2]
    }
    val map = Array(H + 1) { Array(N + 1) { IntArray(M + 1) { 0 } } }
    val visited = Array(H + 1) { Array(N + 1) { BooleanArray(M + 1) { false } } }
    val tomatoList: ArrayList<Coordinate> = ArrayList()

    for (z in 1..H) {
        for (y in 1..N) {
            readLine().split(" ").map { it.toInt() }.forEachIndexed { index, x ->
                map[z][y][index + 1] = x
                if (x == 1) tomatoList.add(Coordinate(z, y, index + 1))
            }
        }
    }
    dfs(visited, tomatoList, map)
    if (checkList(map)) {
        println(depth)
    } else {
        println(-1)
    }
}

fun dfs(visited: Array<Array<BooleanArray>>, tomatoList: ArrayList<Coordinate>, map: Array<Array<IntArray>>) {
    val queue: Queue<Coordinate> = LinkedList()
    tomatoList.forEach { queue.add(it) }.also { tomatoList.clear() }
    while (queue.isNotEmpty()) {
        val item = queue.poll()
        if (!visited[item.z][item.y][item.x]) {
            visited[item.z][item.y][item.x] = true
            for (i in 0 until 6) {
                if (checkBound(
                        dz[i] + item.z,
                        dy[i] + item.y,
                        dx[i] + item.x
                    ) && map[dz[i] + item.z][dy[i] + item.y][dx[i] + item.x] == 0 && !visited[dz[i] + item.z][dy[i] + item.y][dx[i] + item.x]
                ) {
                    map[dz[i] + item.z][dy[i] + item.y][dx[i] + item.x] = 1
                    tomatoList.add(Coordinate(dz[i] + item.z, dy[i] + item.y, dx[i] + item.x))
                }
            }
        }
    }
    if (tomatoList.isEmpty()) { return }
    depth += 1
    dfs(visited, tomatoList, map)
}

fun checkList(map: Array<Array<IntArray>>): Boolean {
    for (z in 1..H) {
        for (y in 1..N) {
            for (x in 1..M) {
                if(map[z][y][x]==0){
                    return false
                }
            }
        }
    }
    return true
}


data class Coordinate(val z: Int, val y: Int, val x: Int)

fun checkBound(z: Int, y: Int, x: Int): Boolean {
    return (1 <= x && 1 <= y && 1 <= z && x <= M && y <= N && z <= H)
}

