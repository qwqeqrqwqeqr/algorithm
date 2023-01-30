package baekjoon.problem11286

import java.util.*
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.abs

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val queue = PriorityQueue<Type>()
    repeat(readLine().toInt()){
        val item = readLine().toInt()
        if(item==0){
            if(queue.isEmpty()){
                bufferedWriter.append("0\n")
            }else{
                bufferedWriter.append("${queue.poll().type}\n")
            }
        }
        else{
            queue.add(Type(item))
        }
    }
    bufferedWriter.flush()
}

data class Type(val type: Int): Comparable<Type> {
    override fun compareTo(other: Type):Int {
        return if(abs(type) == abs(other.type)){
            type - other.type
        }else{
            abs(type)- abs(other.type)
        }
    }
}