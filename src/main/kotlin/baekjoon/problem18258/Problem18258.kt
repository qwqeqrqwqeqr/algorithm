package baekjoon.problem18258

import java.util.LinkedList
import java.util.Queue

val queue: Queue<Int> = LinkedList()
val push: (Int) -> Unit = { queue.add(it) }
val pop: () -> Int = {
    if (queue.isEmpty()) -1
    else queue.poll()
}
val size: () -> Int = { queue.size }
val empty: () -> Int = { if (queue.isEmpty()) 1 else 0 }
val front: () -> Int = { if (queue.isEmpty()) -1 else queue.first() }
val back: () -> Int = { if (queue.isEmpty()) -1 else queue.last() }


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val bufferedWriter = System.out.bufferedWriter()
    repeat(n) {
        val input = readLine().split(" ")
        when (input[0]) {
            "push" -> push(input[1].toInt())
            "pop" -> bufferedWriter.append("${pop()}\n")
            "size" -> bufferedWriter.append("${size()}\n")
            "empty" -> bufferedWriter.append("${empty()}\n")
            "front" -> bufferedWriter.append("${front()}\n")
            "back" -> bufferedWriter.append("${back()}\n")
            else -> {}
        }
    }
    bufferedWriter.flush()
}