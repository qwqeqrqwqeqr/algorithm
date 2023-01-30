package baekjoon.problem11724

import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val graph = Array<Edge>(N+1){ Edge(arrayListOf()) }
    val visited = BooleanArray(N+1){false }
    repeat(M){
        readLine().split(" ").map { it.toInt() }.apply {
            graph[this[0]].edge.add(this[1])
            graph[this[1]].edge.add(this[0])
        }
    }
    var count =0

    for(i in 1 .. N){
        val queue : Queue<Int> = LinkedList()
        queue.add(i)
        if(!visited[i]){ count+=1 }
        while (queue.isNotEmpty()){
            val item = queue.poll()
            if(!visited[item]){
                visited[item] =true
                graph[item].edge.forEach {
                    queue.add(it)
                }
            }
        }
    }

    println(count)

}


class Edge(val edge: ArrayList<Int>)