package baekjoon.problem2580

/*params
index => 깊이 , blank list의 index
number => 해당 깊이에서 1부터 9까지 숫자를 대입할때 사용하는 숫자
y => 1부터 9까지
x => 0부터 8까지
 */


import kotlin.collections.ArrayList
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    var sudoku: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())
    var blankList: ArrayList<Position> = arrayListOf()
    for (i in 0 until 9) {
        sudoku.add(br.readLine().split(' ').map { it.toInt() } as java.util.ArrayList<Int>)
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
        if (isValid(sudoku, blankList[index], i)) {
            sudoku[blankList[index].y][blankList[index].x] = i
            dfs(sudoku, blankList, index + 1)
            sudoku[blankList[index].y][blankList[index].x] = 0
        }
    }


}

fun isValid(sudoku: ArrayList<ArrayList<Int>>, position: Position, number: Int): Boolean {
    //세로
    for (i in 1..9) {
        if (sudoku[i][position.x] == number) {
            return false
        }
    }
    //가로
    for (i in 0 until 9) {
        if (sudoku[position.y][i] == number) {
            return false
        }
    }
    //내부
    for (i in (((position.y)-1) / 3) * 3 + 1..(((position.y)-1) / 3) * 3 + 3) {
        for (j in (position.x / 3) * 3..(position.x / 3) * 3 + 2) {
            if (number == sudoku[i][j]) {
                return false
            }
        }
    }
    return true
}