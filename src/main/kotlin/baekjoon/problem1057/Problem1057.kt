package baekjoon.problem1057

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val (n, a, b) = readLine().split(" ").map { it.toInt() }
    var answer = -1
    repeat(n) { queue.add(it + 1 to 1) }

    while (queue.isNotEmpty()) {
        val first = queue.poll()
        if (queue.isEmpty()) break
        if (queue.peek().second != first.second) {
            queue.add(first.first to first.second + 1)
        } else {
            val second = queue.poll()
            if (first.first == a && second.first == b || first.first == b && second.first == a) {
                answer = second.second
                break
            }
            if (first.first == a || first.first == b) {
                queue.add(first.first to first.second + 1)
                continue
            }
            if (second.first == a || second.first == b) {
                queue.add(second.first to second.second + 1)
                continue
            }
            queue.add(first.first to first.second + 1)
        }
    }
    println(answer)
}
