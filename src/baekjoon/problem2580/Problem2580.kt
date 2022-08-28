package baekjoon.problem2580

import kotlin.collections.ArrayList
import kotlin.system.exitProcess

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var sudoku: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())
    var blankList: ArrayList<Position> = arrayListOf()
    for (i in 0 until 9) {
        var list = readLine().split(' ').map { it.toInt() }
        sudoku.add(list as java.util.ArrayList<Int>)
    }
    sudoku.forEach {
        it.forEach { print(it) }
        println()
    }

    for (i in 1..9) {
        for (j in 0 until 9) {
            if (sudoku[i][j] == 0) {
                blankList.add(Position(i, j))
            }
        }
    }
    dfs(sudoku, blankList, 0)

}

data class Position(val y: Int, val x: Int)

fun dfs(sudoku: ArrayList<ArrayList<Int>>, blankList: ArrayList<Position>, index: Int) {
    if (blankList.size == index) {
        sudoku.forEach {
            it.forEach { print("$it ") }
            println()
        }
        exitProcess(0)
    }
    for (i in 1..9) {
        if (isValid(sudoku, blankList, i, index)) {
            sudoku[blankList[index].y][blankList[index].x] = i
            dfs(sudoku, blankList, index + 1)
            sudoku[blankList[index].y][blankList[index].x] = 0
        }
    }


}

fun isValid(sudoku: ArrayList<ArrayList<Int>>, blankList: ArrayList<Position>, number: Int, index: Int): Boolean {
    //세로
    for(i in 1 .. 9){
        if(sudoku[i][blankList[index].x]==number){
            return false
        }
    }
    //가로
    for(i in 0 until  9){
        if(sudoku[blankList[index].y][i]==number){
            return false
        }
    }
    //내부
    for(i in sudoku[y])
    return true
}