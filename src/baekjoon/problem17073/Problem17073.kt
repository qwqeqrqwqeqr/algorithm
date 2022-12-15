package baekjoon.problem17073

import java.util.LinkedList
import java.util.Queue



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    var treeList = Array(input[0]+1) { EdgeList(arrayListOf()) }
    val visited: Array<Boolean> = Array(input[0]+1) { false }

    var count = 0
    repeat(input[0]-1){
        readLine().split(" ").map { it.toInt() }.also {
            treeList[it[0]].edge.add(it[1])
            treeList[it[1]].edge.add(it[0])
        }
    }
    val queue: Queue<Int> = LinkedList()
    treeList[1].edge.forEach { queue.add(it) }.also { visited[1]=true }

    while (queue.isNotEmpty()){
        val item = queue.poll()
        visited[item] = true

        var temp = 0
        treeList[item].edge.forEach {
            if(!visited[it]){
                queue.add(it)
                temp++
            }
        }
        if(temp==0){ count++ }
    }
    println(String.format("%.15f", input[1].toDouble()/count.toDouble()))
}
data class EdgeList(var edge: java.util.ArrayList<Int>)


