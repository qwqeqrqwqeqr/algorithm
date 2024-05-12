package baekjoon.problem2623

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(n + 1) { 0 }
    val graph = Array<ArrayList<Int>>(n + 1) { ArrayList() }
    val queue: Queue<Int> = LinkedList()
    val answer = ArrayList<Int>()

    repeat(m) {
        val list = readLine().split(" ").map { it.toInt() }.drop(1)
        for (i in list.indices) {
            for (j in i + 1 until list.size) {
                if (!graph[list[i]].contains(list[j])) {
                    graph[list[i]].add(list[j])
                    array[list[j]] += 1
                }
            }
        }
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
    if(answer.size != n) println(0)
    else println(answer.joinToString("\n"))

}

