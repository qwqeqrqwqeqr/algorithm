package baekjoon.problem11656

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val priorityQueue = PriorityQueue<String> { o1, o2 ->
        if (o1.first() == o2.first())
            o2.length - o1.length
        else
            o1.first() - o2.first()
    }
    val input = readLine()

    for (i in input.indices) {
        priorityQueue.add(input.slice(i until input.length))
    }

    priorityQueue.sorted().forEach {
        println(it)
    }

}