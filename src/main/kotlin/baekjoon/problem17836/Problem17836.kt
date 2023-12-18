package baekjoon.problem17836

import java.util.LinkedList
import java.util.Queue

// 상우하좌
val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)
var time = -1
var n = 0
var m = 0
var max_time = 0
const val GRAM_TRUE = 0
const val TRUE = 1
const val FALSE = 2

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M, T) = readLine().split(' ').map { it.toInt() }
    val map = Array(N + 1) { IntArray(M + 1) { 0 } }
    val visited = Array(N + 1) { IntArray(M + 1) { 2 } }
    val queue :Queue<Coordinate> = LinkedList()
    n = N; m = M; max_time =T
    for (y in 1..N) {
        readLine().trim().split(' ').map { it.toInt() }.forEachIndexed { index, x ->
            map[y][index + 1] = x
        }
    }
    if(map[1][1]==2)  queue.add(Coordinate(1,1,true)) else queue.add(Coordinate(1,1,false))

    bfs(map,visited,queue,0)
    if(time==-1) println("Fail") else  println(time)



}
fun bfs(map: Array<IntArray>, visited: Array<IntArray>, queue: Queue<Coordinate>, depth: Int) {
    val tempQueue : Queue<Coordinate> = LinkedList()
    if(depth-1==max_time){ return }
    while (queue.isNotEmpty()){
        val item = queue.poll()
        if(item.y==n&&item.x== m){
            time=depth
            return
        }
        if((visited[item.y][item.x]== FALSE) || (visited[item.y][item.x]== TRUE && item.gram)){
            if(item.gram)  visited[item.y][item.x]= GRAM_TRUE else  visited[item.y][item.x]= TRUE
            for(i in 0 until 4 ){
                if(checkBound(item.y+dy[i],item.x+dx[i])){
                    if(item.gram){
                        if(visited[item.y+dy[i]][item.x+dx[i]] != GRAM_TRUE){
                            tempQueue.add(Coordinate(item.y+dy[i],item.x+dx[i],true))
                        }
                    }else{
                        if(map[item.y+dy[i]][item.x+dx[i]]==2){
                            tempQueue.add(Coordinate(item.y+dy[i],item.x+dx[i],true))
                        }
                        else if(map[item.y+dy[i]][item.x+dx[i]]==0 && visited[item.y+dy[i]][item.x+dx[i]] == FALSE){
                            tempQueue.add(Coordinate(item.y+dy[i],item.x+dx[i],false))
                        }
                    }
                }
            }
        }
    }
    tempQueue.forEach { queue.add(it) }

    bfs(map,visited,queue,depth+1)
}

fun checkBound(y: Int, x: Int): Boolean { return (0 < x && 0 < y && x <= m && y <= n) }

data class Coordinate(val y:Int, val x:Int, val gram:Boolean)


