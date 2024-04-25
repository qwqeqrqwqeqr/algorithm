package baekjoon.problem2578

import java.util.LinkedList


var visited = Array(5) { BooleanArray(5) { false } }
val board = HashMap<Int, Pair<Int, Int>>()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val list = LinkedList<Int>()
    repeat(5) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            board[value] = row to column
        }
    }
    repeat(5) {
        list.addAll(readLine().split(" ").map { it.toInt() })
    }

    list.forEachIndexed { sequence, value ->
        val item = board[value]!!
        visited[item.first][item.second] = true

        if (checkBingoBoard()) {
            println(sequence + 1)
            return@with
        }
    }
}


fun checkBingoBoard(): Boolean {
    var count = 0
    for (item in bingoArray.indices) {
        if (bingoArray[item].none { !visited[it.first][it.second] }) count += 1
    }
    return count >= 3
}

val bingoArray = arrayOf(
    arrayOf(0 to 0, 1 to 1, 2 to 2, 3 to 3, 4 to 4),
    arrayOf(0 to 4, 1 to 3, 2 to 2, 3 to 1, 4 to 0),

    arrayOf(0 to 0, 0 to 1, 0 to 2, 0 to 3, 0 to 4),
    arrayOf(1 to 0, 1 to 1, 1 to 2, 1 to 3, 1 to 4),
    arrayOf(2 to 0, 2 to 1, 2 to 2, 2 to 3, 2 to 4),
    arrayOf(3 to 0, 3 to 1, 3 to 2, 3 to 3, 3 to 4),
    arrayOf(4 to 0, 4 to 1, 4 to 2, 4 to 3, 4 to 4),

    arrayOf(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0),
    arrayOf(0 to 1, 1 to 1, 2 to 1, 3 to 1, 4 to 1),
    arrayOf(0 to 2, 1 to 2, 2 to 2, 3 to 2, 4 to 2),
    arrayOf(0 to 3, 1 to 3, 2 to 3, 3 to 3, 4 to 3),
    arrayOf(0 to 4, 1 to 4, 2 to 4, 3 to 4, 4 to 4)
)