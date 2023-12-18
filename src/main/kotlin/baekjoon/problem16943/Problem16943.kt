package baekjoon.problem16943

import java.util.LinkedList
import java.util.Queue
var max = Int.MIN_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (A,B) = readLine().split(" ")

    val queue: Queue<Int> = LinkedList()
    A.forEach { queue.add(Character.getNumericValue(it)) }
    dfs(queue, B.toInt(), "")
    println(if(max == Int.MIN_VALUE) -1 else max)
}


fun dfs(queue:Queue<Int>,limit:Int, value:String){
    if(queue.isEmpty()){
        if(value.isNotEmpty() && (value.first()!='0') && value.toInt()<limit){ max = Math.max(value.toInt(), max) }
        return
    }
    repeat(queue.size){
        val item = queue.poll()
        dfs(queue,limit,value+item)
        queue.add(item)
    }
}
