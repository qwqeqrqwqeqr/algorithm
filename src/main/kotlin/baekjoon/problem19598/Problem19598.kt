package baekjoon.problem19598

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val timeList = ArrayList<Time>()
    val queue = PriorityQueue<Int>()
    repeat(readLine().toInt()){
        readLine().split(" ").map { it.toInt() }.apply {
            timeList.add(Time(this[0],this[1]))
        }
    }
    timeList.sortedBy { it.start }.forEach {
        if(queue.isEmpty()){ queue.add(it.end) }
        else{
            if(queue.peek()<=it.start){
                queue.poll()
                queue.add(it.end)
            }
            else{
                queue.add(it.end)
            }
        }
    }
    println(queue.size)
}


data class Time(val start:Int, val end:Int)

