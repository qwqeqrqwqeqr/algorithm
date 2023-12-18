package baekjoon.problem2667

import java.util.*
import kotlin.collections.ArrayList

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1) //상우하좌
var N: Int = 0

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    N = nextInt(); nextLine()

    val mapList: ArrayList<java.util.ArrayList<Int>> = arrayListOf(arrayListOf())
    val queue: Queue<Coordinate> = LinkedList<Coordinate>();
    var areaInfoList: ArrayList<Int> = arrayListOf()

    for (i in 1..N) {
        val temp = arrayListOf<Int>()
        next().forEach { temp.add((it - '0'.toInt()).toInt()) }
        nextLine();
        mapList.add(temp)
    }


    /*
    Test Code
     */
    mapList.forEach {
        it.forEach {
            print(it)
        }
        println()
    }

    while (checkNotVisitedArea(queue, mapList)) {
        var count = 1
        while (!queue.isEmpty()) {
            val mapCoordinate = queue.poll();
            count+=check(mapList, queue, mapCoordinate.y, mapCoordinate.x)
        }
        areaInfoList.add(count)
    }
    println(areaInfoList.size)
    areaInfoList.sort()
    areaInfoList.forEach {
        println(it)
    }
}


fun checkNotVisitedArea(queue: Queue<Coordinate>, list: ArrayList<java.util.ArrayList<Int>>): Boolean {
    list.forEachIndexed { y, it ->
        it.forEachIndexed { x, it ->
            if (it == 1) {
                queue.offer(Coordinate(y, x))
                return true
            }
        }
    }
    return false
}

fun check(mapList: ArrayList<ArrayList<Int>>, queue: Queue<Coordinate> ,y: Int, x: Int) :Int{
    var count =0
    mapList[y][x] = 0
    for (i in 0..3) {
        if (checkBound(y + dy[i], x + dx[i])) {
            if (mapList[y + dy[i]][x + dx[i]] == 1) {
                mapList[y + dy[i]][x + dx[i]] = 0;
                queue.offer(Coordinate(y + dy[i], x + dx[i]))
                count+=1
            }
        }
    }
    return count
}


data class Coordinate(val y: Int, val x: Int)

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 < y && x < N && y <= N)
}