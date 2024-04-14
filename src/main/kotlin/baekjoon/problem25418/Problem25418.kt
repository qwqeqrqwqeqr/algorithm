package baekjoon.problem25418

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, k) = readLine().split(" ").map { it.toInt() }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = BooleanArray(1_000_001) { false }

    queue.add(a to 0)

    while (queue.isNotEmpty()) {
        val item = queue.poll()


        if (item.first == k) {
            println(item.second)
            break
        }
        if(item.first>1_000_000) continue


        if (!visited[item.first]) {
            visited[item.first] = true

            queue.add(item.first + 1 to item.second + 1)
            queue.add(item.first * 2 to item.second + 1)
        }
    }
}