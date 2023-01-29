package baekjoon.problem13549

import java.util.PriorityQueue


var target = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N,K) = readLine().split(' ').map { it.toInt() }
    val visited = BooleanArray(100000+1 ){false}
    val priorityQueue = PriorityQueue<Find>().apply { this.add(Find(N,0,0) ) }
    target =K

    bfs(visited,priorityQueue)

}

fun bfs(visited: BooleanArray, queue: PriorityQueue<Find>) {
    while (queue.isNotEmpty()){
        val item = queue.poll()
        if(item.position== target){
            println(item.depth)
            return
        }
        if(!visited[item.position]){
            visited[item.position]=true
            if(item.position!=0&&item.position*2<=100000){
                queue.add(Find(item.position*2, 1,item.depth))
            }
            if(item.position+1<=100000){
                queue.add(Find(item.position+1, 2,item.depth+1))
            }
            if(item.position!=0&&!visited[item.position-1]){
                queue.add(Find(item.position-1, 2,item.depth+1))
            }
        }
    }
}

data class Find(val position :Int, val method:Int,val depth: Int =0): Comparable<Find> {
    override fun compareTo(other: Find): Int {
        if(method == other.method){
           return depth - other.depth
        }
        else{
            return method-other.method
        }
    }
}
