package baekjoon.problem9019

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (A, B) = readLine().split(" ").map { it.toInt() }
        val queue: Queue<Pair<Int, String>> = LinkedList()
        val visited = BooleanArray(10001) { false }
        queue.add(A to "")

        while (true) {
            val item = queue.poll()

            if (item.first == B) {
                println(item.second)
                break
            }
            if (!visited[item.first]) {
                visited[item.first] = true
                queue.add(item.first.D() to item.second + "D")
                queue.add(item.first.S() to item.second + "S")
                queue.add(item.first.L() to item.second + "L")
                queue.add(item.first.R() to item.second + "R")
            }
        }
    }
}

fun Int.D() = (this * 2) % 10000
fun Int.S() = if (this == 0) 9999 else this - 1
fun Int.L(): Int = this % 1000 * 10 + this / 1000
fun Int.R(): Int = this % 10 * 1000 + this / 10

