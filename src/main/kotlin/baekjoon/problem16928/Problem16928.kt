package baekjoon.problem16928

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(101) { false }
    val queue: Queue<Status> = LinkedList()
    val map = HashMap<Int, Int>()
    queue.add(Status(1, 0))

    repeat(input[0]) {
        readLine().split(" ").map { it.toInt() }.apply {
            map[this[0]] = this[1]
        }
    }
    repeat(input[1]) {
        readLine().split(" ").map { it.toInt() }.apply {
            map[this[0]] = this[1]
        }
    }
    while (queue.isNotEmpty()) {
        val item = queue.poll()

        if(item.position==100){
            println(item.count)
            break
        }

        if (!visited[item.position]) {
            visited[item.position] = true

            for(i in 1 .. 6){
                if(checkBound(i+item.position)){
                    if(map.contains(i+item.position)){
                        queue.add(Status(map[i+item.position]!!,item.count+1))
                    }else{
                        queue.add(Status(i+item.position,item.count+1))
                    }
                }
            }
        }
    }
}

fun checkBound (n:Int) :Boolean = n<101

data class Status(val position: Int, val count: Int = 0)

