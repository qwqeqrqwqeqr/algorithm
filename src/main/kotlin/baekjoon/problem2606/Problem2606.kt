package baekjoon.problem2606

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n + 1) { BooleanArray(n + 1) { false } }
    val visited = BooleanArray(n + 1) { false }
    repeat(readLine().toInt()) {
        readLine().split(" ").map { it.toInt() }.also {
            array[it[0]][it[1]] = true
            array[it[1]][it[0]] = true
        }
    }
    val queue: Queue<Int> = LinkedList<Int>().apply {
        array[1].forEachIndexed { index, booleans ->
            if (booleans) {
                add(index)
            }
        }
    }

    while (queue.isNotEmpty()) {
        val item = queue.poll()
        array[item].forEachIndexed { index, booleans ->
            if (booleans && !visited[index]) {
                queue.add(index)
                visited[index] = true
            }
        }
    }
    println(visited.count { it }.let { if (it == 0) 0 else it - 1 })
}



