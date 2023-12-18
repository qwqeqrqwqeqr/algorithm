package baekjoon.problem5547

import java.util.*


val oddDx = intArrayOf(-1, 1, 0, 1, 0, 1)
val oddDy = intArrayOf( 0, 0, 1, 1,-1,-1)

val evenDx = intArrayOf(-1, 1, -1, 0, 0,-1)
val evenDy =intArrayOf( 0, 0, -1,-1, 1, 1)


var M: Int = 0
var N: Int = 0


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply {
        M = this[0];N = this[1];
    }
    val map = Array(N + 2) { IntArray(M + 2) { 0 } }
    val visited = Array(N + 2) { BooleanArray(M + 2) { false } }
    val queue: Queue<Coordinate> = LinkedList()
    var length = 0
    for (y in 1..N) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, x ->
            map[y][index + 1] = x;
            if (x == 1) {
                queue.add(Coordinate(y, index + 1))
            }
        }
    }
    fillBound(visited,map)

    while (queue.isNotEmpty()){
        val item =queue.poll()
        var count = 0
        for(i in 0 until  6){
            val targetY = if(item.y%2==0) item.y+evenDy[i] else item.y+oddDy[i]
            val targetX = if(item.y%2==0) item.x+evenDx[i] else item.x+oddDx[i]
            if(visited[targetY][targetX]){
                count+=1
            }
        }
        length+=count
    }
    println(length)
}

fun fillBound(visited: Array<BooleanArray>, map: Array<IntArray>) {
    val queue: Queue<Coordinate> = LinkedList()
    queue.add(Coordinate(0,0))
    while (queue.isNotEmpty()){
        val item = queue.poll()
        if(!visited[item.y][item.x]){
            visited[item.y][item.x]= true
            for(i in 0 until  6){
                val targetY = if(item.y%2==0) item.y+evenDy[i] else item.y+oddDy[i]
                val targetX = if(item.y%2==0) item.x+evenDx[i] else item.x+oddDx[i]
                if(checkBound(targetY,targetX)&&!visited[targetY][targetX]&&map[targetY][targetX]!=1){
                    queue.add(Coordinate(targetY,targetX))
                }
            }
        }
    }
}


data class Coordinate(val y: Int, val x: Int)




fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x <= M+1 && y <= N+1)
}
