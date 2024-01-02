package baekjoon.problem14940

import java.util.LinkedList
import java.util.Queue

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(-1, 0, 1, 0)
var n = 0
var m = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply { n = get(0); m = get(1) }
    val array = Array(n) { IntArray(m) { -1 } }
    val map = Array(n) { IntArray(m) { -1 } }
    val visited = Array(n) { BooleanArray(m) { false } }
    var goal: Pair<Int, Int> = Pair(0, 0)

    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            array[it][index] = i
            if (i == 2) {
                goal = Pair(it, index)
                map[it][index] = 0
                visited[it][index] = true
            }
            if (i == 0) map[it][index] = i
        }
    }
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>().apply { add(goal) }
    while (queue.isNotEmpty()) {
        val item = queue.poll()
        for (i in 0 until 4) {
            if (checkBound(
                    item.first + dy[i],
                    item.second + dx[i]
                ) && !visited[item.first + dy[i]][item.second + dx[i]]
                && map[item.first + dy[i]][item.second + dx[i]] != 0
            ) {
                queue.add(Pair(item.first + dy[i], item.second + dx[i]))
                visited[item.first + dy[i]][item.second + dx[i]] = true
                map[item.first + dy[i]][item.second + dx[i]] = map[item.first][item.second] + 1
            }
        }
    }

    map.forEach { println(it.joinToString(" ")) }

}

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < m && y < n)
}