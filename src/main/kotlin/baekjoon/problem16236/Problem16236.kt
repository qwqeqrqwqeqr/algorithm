package baekjoon.problem16236

import java.util.LinkedList
import java.util.Queue

var N = 0
var size = 2
var count = 0
var totalTime = 0
var sharkPosition = Coordinate(0, 0, 0)
val dy = intArrayOf(0, -1, 0, 1)
val dx = intArrayOf(-1, 0, 1, 0)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    val map = Array(N) { IntArray(N) { 0 } }

    repeat(N) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            map[it][index] = i
            if (i == 9) sharkPosition = Coordinate(it, index, 0)
        }
    }

    while (true) {
        val result = bfs(N, map)
        if (result == -1) {
            println(totalTime)
            break
        } else {
            totalTime += result
        }
    }
}


fun bfs(N: Int, map: Array<IntArray>): Int {
    val visited = Array(N) { BooleanArray(N) { false } }.apply { this[sharkPosition.y][sharkPosition.x] = true }
    val queue: Queue<Coordinate> = LinkedList<Coordinate>().apply { add(sharkPosition) }
    val feedingList = ArrayList<Coordinate>()
    while (queue.isNotEmpty()) {
        val item = queue.poll()
        for (i in 0 until 4) {
            if (checkBound(
                    item.y + dy[i],
                    item.x + dx[i]
                ) && !visited[item.y + dy[i]][item.x + dx[i]] && map[item.y + dy[i]][item.x + dx[i]] <= size
            ) {
                visited[item.y + dy[i]][item.x + dx[i]] = true
                if (map[item.y + dy[i]][item.x + dx[i]] in 1 until size) {
                    feedingList.add(Coordinate(item.y + dy[i], item.x + dx[i], depth = item.depth + 1))
                }
                queue.add(Coordinate(item.y + dy[i], item.x + dx[i], depth = item.depth + 1))
            }
        }
    }
    if (feedingList.isEmpty()) {
        return -1
    } else {
        val minDepth = feedingList.minOf { it.depth }
        val item =
            feedingList.filter { it.depth == minDepth }.sortedWith(compareBy<Coordinate> { it.y }.thenBy { it.x })
                .first()
        map[sharkPosition.y][sharkPosition.x] = 0
        sharkPosition = Coordinate(item.y, item.x, 0)
        count += 1
        if (size == count) {
            size += 1
            count = 0
        }
        return item.depth
    }
}


data class Coordinate(val y: Int, val x: Int, val depth: Int)

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < N && y < N)
}