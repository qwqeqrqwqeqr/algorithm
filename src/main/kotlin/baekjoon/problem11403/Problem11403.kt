package baekjoon.problem11403

import java.util.LinkedList
import java.util.Queue


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    var graph = Array(input) { IntArray(input) { 0 } }
    var visited = Array(input) { BooleanArray(input) { false } }
    val queue: Queue<Coordinate> = LinkedList()
    repeat(input) { it ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            graph[it][index] = i
        }
    }
    for (i in graph.indices) {
        graph[i].forEachIndexed { j_index, j ->
            if (j == 1) {
                queue.add(Coordinate(i, j_index))
            }
        }
        while (queue.isNotEmpty()) {
            val item = queue.poll()
            if(!visited[item.y][item.x]) {
                visited[item.y][item.x] = true
                graph[item.x].forEachIndexed { j_index, j ->
                    if (j == 1) {
                        queue.add(Coordinate(i, j_index))
                    }
                }
            }
        }
    }

    visited.forEach {
        it.forEach {
            if(!it) print("0 ") else print("1 ")
        }
        println()
    }

}

data class Coordinate(val y: Int, val x: Int)