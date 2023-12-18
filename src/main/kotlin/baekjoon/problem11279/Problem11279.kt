package baekjoon.problem11279

import java.util.*
import java.io.BufferedWriter
import java.io.OutputStreamWriter
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val queue = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(readLine().toInt()){
        val item = readLine().toInt()
        if(item==0){
            if(queue.isEmpty()){
                bufferedWriter.append("0\n")
            }else{
                bufferedWriter.append("${queue.poll()}\n")
            }
        }
        else{
            queue.add(item)
        }
    }
    bufferedWriter.flush()
}


