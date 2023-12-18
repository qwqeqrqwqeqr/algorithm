package baekjoon.problem21736

import java.util.LinkedList
import java.util.Queue


val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, 1, -1)

var N = Int.MAX_VALUE
var M = Int.MAX_VALUE
var count = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply {
        N = this[0]; M = this[1];
    }
    val map = Array(N) { CharArray(M) { '0' } }
    val visited = Array(N) { BooleanArray(M) { false } }
    val queue: Queue<Coordinate> = LinkedList()

    repeat(N) { it ->
        readLine().mapIndexed { index, c ->
            map[it][index] = c

            if (c == 'I') {
                queue.add(Coordinate(it, index))
                visited[it][index] = false
            }
        }
    }
    while (queue.isNotEmpty()) {
        val item = queue.poll()
        if (!visited[item.y][item.x]) {
            visited[item.y][item.x] = true
            if(map[item.y][item.x]=='P') count++
            for (i in 0..3) {
                val targetY = item.y + dy[i]
                val targetX = item.x + dx[i]

                if (checkBound(targetY, targetX) && !visited[targetY][targetX]) {
                    if (map[targetY][targetX] == 'O' || map[targetY][targetX] == 'P') {
                        queue.add(Coordinate(targetY, targetX))
                    }
                }
            }
        }
    }
    println(if(count==0) "TT" else count )
}

data class Coordinate(val y: Int, val x: Int)

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < M && y < N)
}
