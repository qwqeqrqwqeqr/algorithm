package baekjoon.problem1874

import java.util.Stack
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val stringBuilder = StringBuilder()
    val times = readLine().toInt()
    val stack = Stack<Int>()
    var flag = 1
    val targetList = ArrayList<Int>().apply { repeat(times) { add(readLine().toInt())} }
    targetList.forEach {
        while (flag <= it) {
            stack.push(flag++)
            stringBuilder.append("+\n")
        }
        if (stack.peek() == it) {
            stack.pop()
            stringBuilder.append("-\n")
        }
        else {
            println("NO")
            return@with
        }
    }
    println(stringBuilder)
}

