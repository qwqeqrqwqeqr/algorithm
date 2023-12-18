package baekjoon.problem17086

import java.util.LinkedList
import java.util.Queue
import kotlin.math.*

val dx = intArrayOf (-1, -1, -1, 0, 1, 0, 1, 1)
val dy = intArrayOf (-1, 0, 1, 1, 1, -1, 0, -1)
var X = 0
var Y = 0
var max = Int.MIN_VALUE
val map: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    var queue : Queue<Distance> = LinkedList()
    repeat(input[0]) {
        map.add(readLine().split(" ").map { it.toInt() }.toList() as java.util.ArrayList<Int>)
    }.also { map.removeAt(0) }

    var visited = Array(input[0]) { BooleanArray(input[1]) { false } }
    Y = input[0]
    X = input[1]

    map.forEachIndexed { indexI, i ->
        i.forEachIndexed { indexJ, j ->
            if (map[indexI][indexJ]==1){
                visited[indexI][indexJ]= true
                queue.add(Distance(indexI,indexJ,0))
            }
        }
    }

    while (queue.isNotEmpty()){
       val temp =  queue.poll()
        max = max(temp.distance, max)
        for(i in 0 until 8){
            if(checkBound(temp.y+dy[i],temp.x+dx[i])){
                if( visited[temp.y+dy[i]][temp.x+dx[i]] ){ continue }

                visited[temp.y+dy[i]][temp.x+dx[i]] = true
                queue.offer(Distance(temp.y+dy[i],temp.x+dx[i],temp.distance+1))
            }
        }
    }
    println(max)
}


fun checkBound(y: Int, x: Int): Boolean { return (0 <= x && 0 <= y && x < X && y < Y) }

data class Distance(val y: Int, val x : Int, var distance: Int)