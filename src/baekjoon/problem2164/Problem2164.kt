package baekjoon.problem2164

import java.util.LinkedList
import java.util.Queue


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val queue: Queue<Int> = LinkedList()
    readLine().toInt().apply {
        (1 .. this).forEach { queue.add(it) }
        while (queue.size!=1){
            queue.poll()
            queue.add(queue.peek())
            queue.poll()
        }
        println(queue.first())
    }
}
