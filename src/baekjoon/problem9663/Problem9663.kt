package baekjoon.problem9663

import java.util.*
import kotlin.collections.ArrayList

var count = 0
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt() //queen
    var chessBoard: Array<Array<Boolean>> = Array(N) { Array(N) { false } }

    dfs(0, N, chessBoard)

    println(count)
}

fun dfs(index: Int, N: Int, chessBoard: Array<Array<Boolean>>) {
    if (index == N) {
        println("=================")
        chessBoard.forEach {
            it.forEach { print(it) }
            println()
        }
        count += 1
    } else {
        for (i in 0 until chessBoard[index].size)
            if (isValid(chessBoard,index,i,N)) {
                chessBoard[index][i] = true
                dfs(index + 1, N, chessBoard)
                chessBoard[index][i] = false
            } else {
                continue
            }
    }

}


fun isValid(chessBoard: Array<Array<Boolean>>,index: Int, position : Int,N:Int): Boolean {
    for(i in 0  .. index){
        if(chessBoard[i][position]) { return false } //세로검사
    }
    for(i in 0 .. index){
        if(checkBound(index-i,N) && checkBound(position-i,N)) {
            if (chessBoard[index - i][position - i]) {
                return false
            }
        }
        if(checkBound(index-i,N) && checkBound(position+i,N)) {
            if (chessBoard[index - i][position + i]) {
                return false
            }
        }
    }
    return true
}

fun checkBound(index:Int,N:Int):Boolean = index in 0 until N