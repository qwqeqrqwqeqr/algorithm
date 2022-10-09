package baekjoon.problem14502


import baekjoon.problem7576.Coordinate
import java.util.*
import kotlin.collections.ArrayList

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1) //상우하좌
var Y =  0
var X = 0
var max = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val map: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())
    repeat(input[0]) {
        map.add(readLine().split(" ").map { it.toInt() }.toList() as java.util.ArrayList<Int>)
    }
    map.removeAt(0)
    Y= input[0]
    X= input[1]

    dfs(map, 0)

    println(max)

}

fun dfs(map: ArrayList<ArrayList<Int>>, index: Int) {
    if (index == 3) {
        var newMap: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())
        map.forEach { newMap.add(it.clone() as java.util.ArrayList<Int>) }
        newMap.removeAt(0)
        newMap = bfs(newMap)
        max = Math.max(findSafeZone(newMap),max)
        return
    } else {
        map.forEachIndexed { i_index, i ->
            i.forEachIndexed { j_index, j ->
                if (j == 0) {
                    var newMap: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())
                    map.forEach { newMap.add(it.clone() as java.util.ArrayList<Int>) }
                    newMap.removeAt(0)
                    newMap[i_index][j_index] = 1
                    dfs(newMap, index + 1)
                }
            }
        }
    }
}
fun findSafeZone(map: ArrayList<ArrayList<Int>>): Int {
    var count = 0
    map.forEach {
        it.forEach {
            if(it==0){
                count++
            }
        }
    }
    return count
}

fun bfs(map: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
    var queue : Queue<Pair<Int, Int>> = LinkedList()
    map.forEachIndexed { i_index, i ->
        i.forEachIndexed { j_index, j ->
            if (j == 2) { queue.offer( Pair(i_index,j_index)) }
        }
        while (queue.isNotEmpty()){
            val virus = queue.poll()
            check(virus.first,virus.second,map).forEach {
                queue.add(it)
            }
        }
    }
    return map
}
fun checkBound(y: Int, x: Int): Boolean { return (0 <= x && 0 <= y && x < X && y < Y) }

fun check(y:Int,x:Int,map: ArrayList<java.util.ArrayList<Int>>): ArrayList<Pair<Int,Int>> {
    var temp =arrayListOf<Pair<Int,Int>>()
    for (i in 0..3) {
        if(checkBound(y+ dy[i],x+dx[i])){
            if(map[y+ dy[i]][x+dx[i]] == 0){
                map[y+ dy[i]][x+dx[i]] = 2
                temp.add(Pair(y+ dy[i],x+dx[i]))
            }
        }
    }
    return temp
}