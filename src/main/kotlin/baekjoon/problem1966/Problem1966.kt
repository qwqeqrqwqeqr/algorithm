package baekjoon.problem1966

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val (N, M) = readLine().split(" ").map { it.toInt() }
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> queue.add(Pair(index, i)) }
        var count = 1
        while (true) {
            if (queue.first().second == queue.maxOf { it.second }) {
                val item = queue.poll()
                if (item.first == M) {
                    bufferedWriter.append("${count}\n")
                    break
                }
                count++
            } else {
                queue.add(queue.poll())
            }
        }
    }
    bufferedWriter.flush()
}