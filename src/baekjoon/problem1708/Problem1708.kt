package baekjoon.problem1708

import java.util.*

var baseCoordinate : Coordinate = Coordinate(0,0)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var coordinateList = ArrayList<Coordinate>()
    val stack = Stack<Coordinate>()
    repeat(readLine().toInt()){
        readLine().split(" ").map { it.toLong() }.apply {
            coordinateList.add(Coordinate(this[0],this[1]))
        }
    }
    coordinateList.sortWith(compareBy<Coordinate> {it.y}.thenBy { it.x } )
    baseCoordinate=coordinateList[0]
    coordinateList.removeAt(0)

    coordinateList.sort()

    stack.add(baseCoordinate)
    stack.add(coordinateList.first())

    for (i in  1 until  coordinateList.size){
        while (stack.size>=2){
            val secondItem = stack.pop()
            val firstItem = stack.peek()
            if (ccw(firstItem, secondItem, coordinateList[i]) < 0) {
                stack.push(secondItem);
                break;
            }
        }
        stack.push(coordinateList[i])
    }
    println(stack.size)
}
fun dist(a: Coordinate, b: Coordinate) :Long= ((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y))
fun ccw(O: Coordinate, A: Coordinate, B: Coordinate): Long =  (O.x *A.y + A.x * B.y + B.x * O.y) - (A.x * O.y + B.x * A.y + O.x * B.y)
// result > 0 반시계 result == 0 직선  result < 0 시계

//index 기준 오름차순 정렬
data class Coordinate(val x : Long, val y : Long): Comparable<Coordinate> {
    override fun compareTo(other: Coordinate): Int {
        ccw(baseCoordinate, this, other).also {
            if (it > 0) {
                return 1
            } else if (it < 0) {
                return -1
            } else {
                if ( dist(baseCoordinate, this) > dist(baseCoordinate, other)) {
                    return 1
                }
            }
            return -1
        }
    }
}