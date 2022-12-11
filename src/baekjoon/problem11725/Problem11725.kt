package baekjoon.problem11725

import java.util.*


/*
루트노드는 1이다.
 */

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var input = readLine().toInt()
    var treeList = Array(input+1){EdgeList(arrayListOf())}
    val visited : Array<Boolean> = Array(input+1){false}
    val parent : Array<Int> = Array(input+1){0}
    var queue : Queue<Int> = LinkedList()
    repeat(input-1){
        readLine().split(' ').map{ it.toInt() }.let {
            treeList[it[0]].edge.add(it[1])
            treeList[it[1]].edge.add(it[0])
        }
    }
        .apply { treeList[1].edge.forEach {
            parent[it] = 1
            queue.add(it)
        } }
        .apply { visited[1] = true }

    while(queue.isNotEmpty()){
        var node = queue.poll()
        if(!visited[node]){
            treeList[node].edge.forEach {
                queue.add(it)
                if( parent[it] == 0 ){
                    parent[it] =node
                }
            }
            visited[node]=true
        }
    }
    parent.drop(2).forEach {
        println(it)
    }
}


data class EdgeList(var edge: java.util.ArrayList<Int>)