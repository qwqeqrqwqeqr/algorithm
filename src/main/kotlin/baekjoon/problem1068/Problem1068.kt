package baekjoon.problem1068

import java.util.LinkedList
import java.util.Queue


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    var treeList = Array(input) { EdgeList(arrayListOf()) }
    val visited: Array<Boolean> = Array(input) { false }
    var root: Int = 0
    val queue: Queue<Int> = LinkedList()
    var count = 0

    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        if (i != -1) {
            treeList[i].edge.add(index)
        } else {
            root = index
        }
    }
    val target = readLine().toInt()
    treeList[target].edge.clear()

    treeList[root].edge.filter { it != target }.forEach { queue.add(it) }
    if(root==target){ //예외처리
        println(0)
    }
    else if (queue.size == 0) {  //예외처리
        println(1)
    } else {
        while (queue.isNotEmpty()) {
            val edgeList = treeList[queue.poll()].edge.filter { it != target }
            if (edgeList.isEmpty()) { //자식어없냐?
                count += 1
            }
            edgeList.forEach { queue.add(it) }
        }

        println(count)

    }
}



data class EdgeList(var edge: java.util.ArrayList<Int>)