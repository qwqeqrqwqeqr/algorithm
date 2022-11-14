package baekjoon.problem11000

import java.util.PriorityQueue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val assignList = ArrayList<Pair<Int, Int>>()
    val priorityQueue = PriorityQueue<Int>()
    repeat(N) {
        readLine().split(" ").map { it.toInt() }.toList().let { assignList.add(Pair(it[0], it[1])) }
    }
    assignList.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })

    assignList.forEach {
        if (priorityQueue.isNotEmpty() && it.first >= priorityQueue.peek()) {
            priorityQueue.poll()
        }
        priorityQueue.offer(it.second)
    }


    println(priorityQueue.size)

}