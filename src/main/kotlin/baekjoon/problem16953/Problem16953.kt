package baekjoon.problem16953

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (A, B) = readLine().split(" ").map { it.toLong() }

    val queue: Queue<Pair<Long, Int>> = LinkedList()
    val answer: PriorityQueue<Pair<Long, Int>> = PriorityQueue { o1, o2 -> o1.second - o2.second }
    val hashMap = HashMap<Long, Unit>()
    queue.add(A to 1)

    while (queue.isNotEmpty()) {
        val item = queue.poll()
        if (item.first == B) {
            answer.add(item)
            break
        }
        if (item.first > 1000000001 || item.first < 1) continue

        if (hashMap[item.first] == null) {
            hashMap[item.first] = Unit
            queue.add(item.first * 2 to item.second + 1)
            queue.add(item.first * 10 + 1 to item.second + 1)
        }
    }
    println(answer)
    if (answer.isNotEmpty()) println(answer.first().second) else println("-1")
}