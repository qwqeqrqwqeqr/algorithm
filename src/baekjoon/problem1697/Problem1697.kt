package baekjoon.problem1697

import java.util.LinkedList
import java.util.Queue
import kotlin.system.exitProcess


var min = Int.MAX_VALUE
var target =0
var depth =0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n,k) =readLine().split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(1000001){false}
    target= k
    queue.add(n)
    while (true){
        bfs(queue,visited).forEach { queue.add(it) }
        depth+=1
    }

}

fun bfs(queue: Queue<Int>,visited:BooleanArray):List<Int>{
    val list = arrayListOf<Int>()
    while (queue.isNotEmpty()){
        val item = queue.poll()
        if(item == target){
            println(depth)
            exitProcess(0) }
        if(check(item+1,visited)){
            visited[item+1]=true
            list.add(item+1)
        }
        if(check(item-1,visited)){
            visited[item-1]=true
            list.add(item-1)
        }
        if(check(item*2,visited)){
            visited[item*2]=true
            list.add(item*2)
        }

    }
    return list
}

fun check(number:Int,visited: BooleanArray):Boolean{
    if (number < 0 || number > 100000 || visited[number])
        return false;
    return true;
}