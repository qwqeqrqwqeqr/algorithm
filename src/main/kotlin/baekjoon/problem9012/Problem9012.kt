package baekjoon.problem9012

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Stack

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(readLine().toInt()) {
        var flag = false
        run {
            val stack = Stack<Char>()
            readLine().forEach {
                when (it) {
                    '(' -> stack.push(it)
                    else -> {
                        if (stack.isEmpty()) return@run
                        if (stack.peek() == ')') return@run
                        stack.pop()
                    }
                }
            }
            if(stack.isEmpty()) flag =true
        }
        bufferedWriter.append(if (flag) "YES\n" else "NO\n")
    }
    bufferedWriter.flush()
}