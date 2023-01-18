package wanted.showmethecode20230114.round2

import java.util.*

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)
var M: Int = 0
var N: Int = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val input = readLine().split(" ").map { it.toInt() }
    val map = Array(input[0] + 1) { IntArray(input[1] + 1) }
    val visited = Array(input[0] + 1) { BooleanArray(input[1] + 1) }
    val queue: Queue<Coordinate> = LinkedList<Coordinate>();
    val tempQueue: Queue<Coordinate> = LinkedList<Coordinate>();
    var answer = 0

    repeat(input[0]) {
        readLine().split(" ").map { it.toInt() }.toList().forEachIndexed { index, i ->
            map[it + 1][index + 1] = i
            if (i == 0) {
                queue.add(Coordinate(it + 1, index + 1))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val tmp = queue.poll()
        if (!visited[tmp.y][tmp.x]) {
            answer += 1
            tempQueue.add(tmp)
            while (tempQueue.isNotEmpty()) {
                val item = tempQueue.poll()
                for (i in 0 until 4) {
                    val targetY = convertCoordinate(item.y+dy[i],input[0])
                    val targetX = convertCoordinate(item.x+dx[i],input[1])
                    if(!visited[targetY][targetX]&&map[targetY][targetX]!=1){
                        tempQueue.add(Coordinate(targetY,targetX))
                        visited[targetY][targetX]=true
                    }
                }
            }
        }
    }
    println(answer)
}

fun convertCoordinate(target: Int, bound: Int): Int {
    if (target <= 0) {
        return bound
    } else if (target > bound) {
        return 1
    } else {
        return target
    }
}

data class Coordinate(val y: Int, val x: Int)