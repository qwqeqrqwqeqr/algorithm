package baekjoon.problem10828

import java.util.Stack


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val stack = Stack<Int>()
    val bufferedWriter = System.out.bufferedWriter()

    repeat(readLine().toInt()){

        readLine().split(" ").apply {
            when(this[0]){
                "push" -> {
                    stack.push(this[1].toInt())
                }
                "pop" -> {
                    bufferedWriter.append("${if(stack.isEmpty()) -1 else stack.pop()}\n")
                }
                "size" -> {
                    bufferedWriter.append("${stack.size}\n")
                }
                "empty" -> {
                    bufferedWriter.append("${if(stack.isEmpty()) 1 else 0}\n")
                }
                "top" -> {
                    bufferedWriter.append("${if(stack.isEmpty()) -1 else stack.peek()}\n")
                }
            }
        }
    }

    bufferedWriter.flush()
}
