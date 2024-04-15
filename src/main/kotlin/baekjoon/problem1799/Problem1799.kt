package baekjoon.problem1799


var blackMax = Int.MIN_VALUE
var whiteMax = Int.MIN_VALUE

var whiteBoard: Array<IntArray> = Array(10) { IntArray(10) }
var blackBoard: Array<IntArray> = Array(10) { IntArray(10) }

var dy = intArrayOf(-1, 1, 1, -1)
var dx = intArrayOf(-1, -1, 1, 1)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            whiteBoard[row][column] = value
            blackBoard[row][column] = value
        }
    }

    backTrackingWhite(0, 0, n, 0)
    backTrackingBlack(0, 1, n, 0)


    println(whiteMax + blackMax)
}

fun backTrackingWhite(row: Int, column: Int, n: Int, count: Int) {
    var newRow = row
    var newColumn = column
    if (newColumn >= n) {
        newRow += 1
        newColumn = if (newRow % 2 == 1) 1 else 0
    }

    if (newRow >= n) {
        whiteMax = Math.max(whiteMax, count)
        return
    }


    if (checkBoard(n, newRow, newColumn, true) && whiteBoard[newRow][newColumn] == 1) {
        whiteBoard[newRow][newColumn] = 9
        backTrackingWhite(newRow, newColumn + 2, n, count + 1)
        whiteBoard[newRow][newColumn] = 1;
    }


    backTrackingWhite(newRow, newColumn + 2, n, count)
}

fun backTrackingBlack(row: Int, column: Int, n: Int, count: Int) {
    var newRow = row
    var newColumn = column
    if (newColumn >= n) {
        newRow += 1
        newColumn = if (newRow % 2 == 1) 0 else 1
    }
    if (newRow >= n) {
        blackMax = Math.max(blackMax, count)
        return
    }


    if (checkBoard(n, newRow, newColumn, false) && blackBoard[newRow][newColumn] == 1) {
        blackBoard[newRow][newColumn] = 9;
        backTrackingBlack(newRow, newColumn + 2, n, count + 1)
        blackBoard[newRow][newColumn] = 1;
    }


    backTrackingBlack(newRow, newColumn + 2, n, count)
}


fun checkBound(x: Int, y: Int, n: Int): Boolean = (x in 0 until n) && (y in 0 until n)

fun checkBoard(n: Int, row: Int, column: Int, isWhite: Boolean): Boolean {
    val board = if (isWhite) whiteBoard else blackBoard
    for (i in 0 until 4) {
        var count = 1
        while (true) {
            val r = row + dy[i] * count
            val c = column + dx[i] * count
            if (!checkBound(r, c, n)) break
            if (board[r][c] == 9) return false

            count += 1
        }
    }
    return true
}

