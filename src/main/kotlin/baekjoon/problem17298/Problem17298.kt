package baekjoon.problem17298

import java.util.Stack

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val stack = Stack<Int>()
    val answer = IntArray(N) { -1}
    for (i in list.indices) {
        while (stack.isNotEmpty()) {
            if (list[stack.peek()] < list[i]) {
                answer[stack.pop()] = list[i]
            } else {
                break
            }
        }
        stack.push(i)
    }
    print(answer.joinToString(" "))
}

