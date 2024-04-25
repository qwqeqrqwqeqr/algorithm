package baekjoon.problem28278

import java.util.Stack


val stack = Stack<Int>()
val bufferedWriter = System.out.bufferedWriter()


val push: (Int) -> Unit = {
    stack.push(it)
}
val pop: () -> Unit = {
    if (stack.isEmpty()) bufferedWriter.append("-1\n")
    else bufferedWriter.append("${stack.pop()}\n")
}
val size: () -> Unit = {
    bufferedWriter.append("${stack.size}\n")
}
val isEmpty: () -> Unit = {
    if (stack.isEmpty()) bufferedWriter.append("1\n")
    else bufferedWriter.append("0\n")
}
val peek: () -> Unit = {
    if (stack.isEmpty()) bufferedWriter.append("-1\n")
    else bufferedWriter.append("${stack.peek()}\n")
}

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val value = readLine().split(" ").map { it.toInt() }
        when (value[0]) {
            1 -> push(value[1])
            2 -> pop()
            3 -> size()
            4 -> isEmpty()
            5 -> peek()
            else -> {}
        }
    }
    bufferedWriter.flush()
}