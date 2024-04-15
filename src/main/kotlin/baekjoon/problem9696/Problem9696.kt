package baekjoon.problem9696

import java.util.LinkedList
import java.util.Queue


val op1 = arrayOf("+", "-")
val op2 = arrayOf("*", "/")
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val deque1: ArrayDeque<String> = ArrayDeque()
        val deque2: ArrayDeque<String> = ArrayDeque()
        val operatorQueue: Queue<String> = LinkedList()
        readLine().split(" ").forEach { deque1.addLast(it) }

        while (deque1.isNotEmpty()) {
            val item = deque1.first();deque1.removeFirst()
            when (item) {
                in op2 -> {
                    operatorQueue.add(item)
                    val temp = deque2.last(); deque2.removeLast()
                    if (item == "*") deque2.addLast((temp.toInt() * deque1.first().toInt()).toString())
                    if (item == "/") deque2.addLast((temp.toInt() / deque1.first().toInt()).toString())
                    deque1.removeFirst()
                }
                else -> deque2.addLast(item)
            }
        }
        while (deque2.isNotEmpty()) {
            val item = deque2.first();deque2.removeFirst()
            when (item) {
                in op1 -> {
                    operatorQueue.add(item)
                    val temp = deque1.last(); deque1.removeLast()
                    if (item == "+") deque1.addLast((temp.toInt() + deque2.first().toInt()).toString())
                    if (item == "-") deque1.addLast((temp.toInt() - deque2.first().toInt()).toString())
                    deque2.removeFirst()
                }
                else -> deque1.addLast(item)
            }
        }
        operatorQueue.addAll(deque1)
        println("Case #${it+1}: ${operatorQueue.joinToString(" ")}")
    }
}

