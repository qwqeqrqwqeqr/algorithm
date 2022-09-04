package baekjoon.problem12100

import kotlin.math.max

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)
var count = 0
fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    var N = br.readLine().toInt()
    var board: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())
    for (i in 0 until N) {
        board.add(br.readLine().split(' ').map { it.toInt() } as java.util.ArrayList<Int>)
    }
    dfs(N, 0, board)

    println(count)
}

fun dfs(N: Int, index: Int, board: ArrayList<ArrayList<Int>>) {
    if (index == 5) { return }

    for (i in 0 until 4) {
        var swallowCopy : ArrayList<ArrayList<Int>>  = arrayListOf(arrayListOf())
        for(j in 1 .. N){ swallowCopy.add(board[j]) }
        val newBoard = move(N, swallowCopy, i)
        println("count = $count  index = $index  direction = $i")
        dfs(N, index + 1, newBoard)
        newBoard.clear()
        for(j in 1 .. N){ swallowCopy.add(board[j]) }
    }
}



fun move(N: Int, board: ArrayList<ArrayList<Int>>, direction: Int): ArrayList<ArrayList<Int>> {
    for (i in 1..N) {
        for (j in 0 until N) {
            if (board[i][j] == 0) {
                continue
            }
            if (!checkBoundY(i, N) || !checkBoundX(j, N)) { continue }

            var targetY = i + dy[direction]
            var targetX = j + dx[direction]
            while (checkBoundY(targetY, N) &&
                checkBoundX(targetX, N) &&
                board[targetY][targetX] == 0
            ) {
                targetY += dy[direction]
                targetX += dx[direction]
            }
            if (!checkBoundY(targetY, N) || !checkBoundX(targetX, N)) { continue }
            if (board[targetY][targetX] == 0 || board[targetY][targetX] == -1) {
                board[targetY][targetX] = board[i][j]
                board[i][j] = 0
            } else {
                if (board[targetY][targetX] == board[i][j]) {
                    board[targetY][targetX] += board[i][j]
                    board[i][j] = -1
                }
            }
        }
    }

    count = max(findMax(board), count)

    for (i in 1..N) {
        for (j in 0 until N) {
            if (board[i][j] == -1) {
                board[i][j] = 0
            }
        }
    }

    return board
}

fun findMax(board: ArrayList<ArrayList<Int>>): Int {
    var temp = 0
    board.forEach {
        it.forEach {
            temp = max(temp, it)
        }
    }
    return temp
}


fun checkBoundX(index: Int, N: Int): Boolean = index in 0 until N
fun checkBoundY(index: Int, N: Int): Boolean = index in 1..N