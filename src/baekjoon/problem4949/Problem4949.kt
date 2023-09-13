package baekjoon.problem4949

import java.util.Stack

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val stack = Stack<Char>()
    val bufferedWriter = System.out.bufferedWriter()
    while (true) {
        val line = readLine()
        if (line.toString() == ".") break
        var flag = true
        for (i in line.indices) {
            when (line[i]) {
                '[' -> {
                    stack.add(line[i])
                }

                '(' -> {
                    stack.add(line[i])
                }

                ']' -> {
                    if (stack.isEmpty()) {
                        flag = false
                        break
                    } else if (stack.peek() == '(') {
                        flag = false
                        break
                    } else if (stack.peek() == '[') {
                        stack.pop()
                    }
                }

                ')' -> {
                    if (stack.isEmpty()) {
                        flag = false
                        break
                    } else if (stack.peek() == '(') {
                        stack.pop()
                    } else if (stack.peek() == '[') {
                        flag = false
                        break
                    }
                }
            }
        }
        bufferedWriter.append(if (flag&&stack.isEmpty()) "yes\n" else "no\n")
        stack.clear()
    }
    bufferedWriter.flush()
}