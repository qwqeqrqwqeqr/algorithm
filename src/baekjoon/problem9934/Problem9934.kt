package baekjoon.problem9934

import java.util.LinkedList
import java.util.Queue



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val nodeList = readLine().split(" ").map { it.toInt() }
    val tree: ArrayList<Child> = ArrayList<Child>()
    val queue: Queue<Int> = LinkedList()
    val tempQueue : Queue<Int> = LinkedList()
    repeat(3000) { tree.add(Child()) }
    makeTree(nodeList, tree)
    queue.add(nodeList[nodeList.size/2])


    while (queue.isNotEmpty()){
        val item = queue.poll()
        print("$item ")
        if(tree[item].left != 0) tempQueue.add(tree[item].left)
        if(tree[item].right != 0)  tempQueue.add(tree[item].right)
        if(queue.size==0){
            println()
            tempQueue.forEach { queue.add(it) }
            tempQueue.clear()
        }
    }
}

fun makeTree(list: List<Int>, tree: ArrayList<Child>): Int {
    if (list.size == 1) {
        return list[0]
    }
    tree[list[list.size / 2]].left = makeTree(list.slice(0 until list.size / 2), tree)
    tree[list[list.size / 2]].right = makeTree(list.slice((list.size / 2) + 1 until list.size), tree)
    return list[list.size / 2]
}


data class Child(var left: Int = 0, var right: Int = 0)