package baekjoon.problem1240

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter((System.out)))
    val input = readLine().split(" ").map { it.toInt() }
    var treeList = Array(input[0] + 1) { EdgeList(arrayListOf()) }
    repeat(input[0] - 1) {
        readLine().split(" ").map { it.toInt() }.also {
            treeList[it[0]].edge.add(Node(it[1], it[2]))
            treeList[it[1]].edge.add(Node(it[0], it[2]))
        }
    }
    repeat(input[1]) {
        val target = readLine().split(" ").map { it.toInt() }
        val queue: Queue<Node> = LinkedList()
        val visited: Array<Boolean> = Array(input[0] + 1) { false }
        treeList[target[0]].edge.forEach { queue.add(it) }
        visited[target[0]]=true
        while (true){
            val item =queue.poll()
            if(item.node == target[1]){ bw.append("${item.distance}\n"); break}
            if(!visited[item.node]){
                visited[item.node]=true
                treeList[item.node].edge.forEach {
                    if(!visited[it.node]){
                        queue.add(Node(it.node,it.distance+item.distance))
                    }
                }
            }
        }
    }
    bw.flush()
}


data class EdgeList(var edge: java.util.ArrayList<Node>)

data class Node (var node :Int , var distance: Int)