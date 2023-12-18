package baekjoon.problem2468


import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1) //상우하좌
var N: Int = 0

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    N = nextInt(); nextLine()
    val floodList: ArrayList<java.util.ArrayList<Int>> = arrayListOf(arrayListOf())

    val queue: Queue<Coordinate> = LinkedList<Coordinate>();
    var maxHeight = 0
    var answer = 0
    for (i in 1..N) {
        val tempList = arrayListOf<Int>().also { it.clear() }
        for (j in 1..N) {
            val temp = nextInt()
            tempList.add(temp)
            maxHeight = max(maxHeight, temp)
        }
        nextLine();
        floodList.add(tempList)
    }


    /*
    Test Code
     */
    floodList.forEach {
        it.forEach {
            print(it)
        }
        println()
    }

    for (height in 0..maxHeight) {


        val floodTempList: ArrayList<java.util.ArrayList<Int>> = arrayListOf(arrayListOf())
        copyList(floodList,floodTempList)

        mapToZeroOneList(floodTempList, height)

        /*
           Test Code
            */
        println("===========height : $height=================")

        floodTempList.forEach {
            it.forEach {
                print(it)
            }
            println()
        }
        println("==========================================")


        var count = 0
        while (checkNotVisitedArea(queue, floodTempList)) {
            while (!queue.isEmpty()) {
                val floodCoordinate = queue.poll();
                check(floodTempList, queue, floodCoordinate.y, floodCoordinate.x)
            }
            count += 1
        }
        answer = max(answer, count)
    }

    println(answer)
}

fun copyList(srcList:ArrayList<java.util.ArrayList<Int>>, dstList: ArrayList<java.util.ArrayList<Int>> ){
    for (y in 1..N) {
        val tempList = arrayListOf<Int>()
        for (x in 0 until N) {
            tempList.add(srcList[y][x])
        }
        dstList.add(tempList)
    }
}

fun mapToZeroOneList(list: ArrayList<java.util.ArrayList<Int>>, height: Int) {
    list.forEachIndexed { y, it ->
        it.forEachIndexed { x, it ->
            if (it <= height) {
                list[y][x] = 0
            } else {
                list[y][x] = 1
            }
        }
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

fun check(mapList: ArrayList<ArrayList<Int>>, queue: Queue<Coordinate>, y: Int, x: Int) {
    mapList[y][x] = 0
    for (i in 0..3) {
        if (checkBound(y + dy[i], x + dx[i])) {
            if (mapList[y + dy[i]][x + dx[i]] == 1) {
                mapList[y + dy[i]][x + dx[i]] = 0;
                queue.offer(Coordinate(y + dy[i], x + dx[i]))
            }
        }
    }
}


data class Coordinate(val y: Int, val x: Int)

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 < y && x < N && y <= N)
}