package baekjoon.problem2178

import java.util.*

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1) //상우하좌
var M: Int = 0
var N: Int = 0

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    N = nextInt()
    M = nextInt(); nextLine()

    val mazeList: ArrayList<java.util.ArrayList<Int>> = arrayListOf(arrayListOf())
    val queue: Queue<Coordinate> = LinkedList<Coordinate>();
    val tempList: ArrayList<Coordinate> = arrayListOf()
    var depth = 1

    for (i in 1..N) {
        val temp = arrayListOf<Int>()
        next().forEach { temp.add((it - '0'.toInt()).toInt()) }
        nextLine();
        mazeList.add(temp)
    }


    /*
    Test Code
     */
//    mazeList.forEach {
//        it.forEach {
//            print(it)
//        }
//        println()
//    }

    queue.offer(Coordinate(1, 0))
    while (!queue.isEmpty() || tempList.isNotEmpty()) {
        if (queue.isEmpty()) {
            tempList.forEach { queue.offer(Coordinate(it.y, it.x)) }
            depth += 1 //depth
            tempList.clear()
        }
        val mazeCoordinate = queue.poll();
        if (checkLastMaze(mazeCoordinate)){
            println(depth)
            break
        }
        check(mazeList, tempList, mazeCoordinate.y, mazeCoordinate.x)
    }



}

fun checkLastMaze(mazeCoordinate: Coordinate) : Boolean {
    return mazeCoordinate.y == N && mazeCoordinate.x == M-1
}

fun check(mazeList: ArrayList<ArrayList<Int>>, tempList: ArrayList<Coordinate>, y: Int, x: Int) {
    for (i in 0..3) {
        if (checkBound(y + dy[i], x + dx[i])) {
            if (mazeList[y + dy[i]][x + dx[i]] == 1) {
                mazeList[y + dy[i]][x + dx[i]] = 0;
                tempList.add(
                    Coordinate(
                        y + dy[i],
                        x + dx[i]
                    )
                )
            }
        }
    }
}


data class Coordinate(val y: Int, val x: Int)

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 < y && x < M && y <= N)
}