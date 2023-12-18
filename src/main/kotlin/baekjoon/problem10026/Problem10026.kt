package baekjoon.problem10026

import java.util.LinkedList
import java.util.Queue

var N = 0
val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1) //상우하좌
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    var visited = Array(N) { BooleanArray(N) { false } }
    val map = Array(N) { CharArray(N) { 'A' } }


    repeat(N) { map[it] = readLine().toCharArray() }


    val rgbCount= bfs(visited, map)
    for (i in 0 until N) {
        for (j in 0 until N) {
            if(map[i][j]=='R'){
                map[i][j]='G'
            }
        }
    }
    visited = Array(N) { BooleanArray(N) { false } }
    val gbCount = bfs(visited,map)

    println("$rgbCount $gbCount")
}

fun bfs(visited: Array<BooleanArray>, map: Array<CharArray>): Int {
    var count = 0
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (!visited[i][j]) {
                visited[i][j] = true
                queue.add(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val item = queue.poll()
                    for (k in 0 until 4) {
                        if (checkBound(item.first + dy[k], item.second + dx[k])) {
                            if (!visited[item.first + dy[k]][item.second + dx[k]] &&
                                map[i][j] == map[item.first + dy[k]][item.second + dx[k]]
                            ) {
                                visited[item.first + dy[k]][item.second + dx[k]] = true
                                queue.add(Pair(item.first + dy[k], item.second + dx[k]))
                            }
                        }
                    }
                }
                count += 1
            }
        }
    }
    return count
}

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < N && y < N)
}

