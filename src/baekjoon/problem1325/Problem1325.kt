package baekjoon.problem1325

import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt(); nextLine()
    val trustList: Array<Computer> = Array(N+1){Computer(arrayListOf())}
    var answer : ArrayList<Int> = arrayListOf()
    var max =0
    for (i in 1..M) {
        var src = nextInt()
        var dst = nextInt()
        trustList[dst].edge.add(src)
    }

    trustList.forEachIndexed { index, computer ->
        println("index  $index")
        computer.edge.forEach {
            print("$it   ")
        }
        println()
    }
    for(i in 1 .. N){
       val result =bfs(i,N,trustList)
       if(max <=  result){
           answer.add(i)
           max = result
       }
    }
    answer.sort().let { answer.forEach { print("$it ")  } }
}


fun bfs(node : Int,size : Int,trustList: Array<Computer>): Int {
    var que : Queue<Int> = LinkedList<Int>();
    val visited : Array<Boolean> = Array(size = size+1){false}
    var count =1
    que.offer(node)
    visited.fill(false)
    visited[node] = true

    while( !que.isEmpty() ) {
        var node = que.poll();
        trustList[node].edge.forEach {
            if( !visited[it] ) {
                que.offer(it);
                visited[it] = true;
                count++
            }
        }
    }
    que.clear()
    return count
}
data class Computer(var edge: java.util.ArrayList<Int>)