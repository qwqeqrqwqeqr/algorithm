package baekjoon.problem2493

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(n)
    val stack = Stack<Pair<Int, Int>>()
    val answer: Queue<Int> = LinkedList()

    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> array[index] = i }

    for (i in array.indices) {
        while (stack.isNotEmpty()) {
            if (stack.peek().first > array[i]) {
                answer.add(stack.peek().second)
                break
            } else stack.pop()
        }
        if (stack.isEmpty()) {
            answer.add(0)
        }
        stack.push(array[i] to i + 1)
    }
    println(answer.joinToString(" "))
}

