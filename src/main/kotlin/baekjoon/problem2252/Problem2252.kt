package baekjoon.problem2252

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(n + 1) { 0 }
    val graph = Array<ArrayList<Int>>(n + 1) { ArrayList() }
    val queue: Queue<Int> = LinkedList()
    val answer = ArrayList<Int>()
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        array[b] += 1
    }

    for (i in 1 .. n) {
        if (array[i] == 0) queue.add(i)
    }

    while (queue.isNotEmpty()) {
        val item = queue.poll()
        answer.add(item)

        graph[item].forEach {
            array[it] -= 1
            if (array[it] == 0) queue.add(it)
        }
    }
    println(answer.joinToString(" "))
}