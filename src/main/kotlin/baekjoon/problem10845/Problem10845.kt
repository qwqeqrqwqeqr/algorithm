package baekjoon.problem10845

import java.util.LinkedList
import java.util.Queue
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val queue : Queue<Int> = LinkedList()
    val bufferedWriter = System.out.bufferedWriter()

    repeat(readLine().toInt()){

        readLine().split(" ").apply {
            when(this[0]){
                "push" -> {
                    queue.add(this[1].toInt())
                }
                "pop" -> {
                    bufferedWriter.append("${if(queue.isEmpty()) -1 else queue.poll()}\n")
                }
                "size" -> {
                    bufferedWriter.append("${queue.size}\n")
                }
                "empty" -> {
                    bufferedWriter.append("${if(queue.isEmpty()) 1 else 0}\n")
                }
                "front" -> {
                    bufferedWriter.append("${if(queue.isEmpty()) -1 else queue.first()}\n")
                }
                "back" -> {
                    bufferedWriter.append("${if(queue.isEmpty()) -1 else queue.last()}\n")
                }
            }
        }
    }

    bufferedWriter.flush()
}
