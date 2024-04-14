package baekjoon.problem1918

import java.util.Stack

val op1 = arrayOf('+', '-')
val op2 = arrayOf('*', '/')

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val stack = Stack<Char>()

    readLine().forEach { item ->
        if (item.isLetter()) {
            stack.push(item)
        } else {
            when (item) {
                in op1 -> {
                    while (stack.isNotEmpty()) {
                        val temp = stack.peek()
                        if (temp in op2 || temp.isLetter())
                            print(stack.pop())
                        else if(temp in op1)
                            print(stack.pop())
                        else break
                    }
                    stack.push(item)
                }

                in op2 -> {
                    while (stack.isNotEmpty()) {
                        val temp = stack.peek()
                        if (temp.isLetter())
                            print(stack.pop())
                        else if(temp in op2)
                            print(stack.pop())
                        else break
                    }
                    stack.push(item)
                }

                '(' -> {
                    stack.push(item)
                }
                ')' -> {
                    while (stack.isNotEmpty()){
                        val temp = stack.peek()
                        if (temp=='(') {
                            stack.pop()
                            break
                        }
                        print(stack.pop())
                    }
                }
                else -> {}
            }
        }
    }
    while (stack.isNotEmpty()) {
        print(stack.pop())
    }
}
