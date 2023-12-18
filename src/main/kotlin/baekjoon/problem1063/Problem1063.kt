package baekjoon.problem1063

import java.util.*
import kotlin.collections.ArrayList


/**
 * R : 한 칸 오른쪽으로
 * L : 한 칸 왼쪽으로
 * B : 한 칸 아래로
 * T : 한 칸 위로
 * RT : 오른쪽 위 대각선으로
 * LT : 왼쪽 위 대각선으로
 * RB : 오른쪽 아래 대각선으로
 * LB : 왼쪽 아래 대각선으로
 */

/*
A=65
H=72
 */

/*
1=49
8=56
 */

data class Position(var column: Int, var row: Int)

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var kingPosition: Position
    var stonePosition: Position
    var tempKingPosition : Position
    var tempStonePosition : Position
    next().let { kingPosition = Position(it[0].toInt(), it[1].toInt()) }
    next().let { stonePosition = Position(it[0].toInt(), it[1].toInt()) }
    val count = nextInt(); nextLine()
    val moveList: ArrayList<String> = java.util.ArrayList()
    for (i in 1..count) {
        moveList.add(nextLine())
    }
    moveList.forEach {
        tempKingPosition= kingPosition.copy()
        tempStonePosition= stonePosition.copy()
        when (it) {
            "R" -> {
                tempKingPosition.column++
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.column++
                }
            }
            "L" -> {
                tempKingPosition.column--
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.column--
                }
            }
            "B" -> {
                tempKingPosition.row--
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.row--
                }
            }
            "T" -> {
                tempKingPosition.row++
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.row++
                }
            }
            "RT" -> {
                tempKingPosition.column++
                tempKingPosition.row++
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.column++
                    tempStonePosition.row++
                }
            }
            "LT" -> {
                tempKingPosition.column--
                tempKingPosition.row++
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.column--
                    tempStonePosition.row++
                }
            }
            "RB" -> {
                tempKingPosition.column++
                tempKingPosition.row--
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.column++
                    tempStonePosition.row--
                }
            }
            "LB" -> {
                tempKingPosition.column--
                tempKingPosition.row--
                if(tempKingPosition==tempStonePosition){
                    tempStonePosition.column--
                    tempStonePosition.row--
                }
            }
        }
        if(tempKingPosition.column<65||tempKingPosition.column>72||
            tempStonePosition.column<65||tempStonePosition.column>72||
            tempKingPosition.row<49||tempKingPosition.row>56||
            tempStonePosition.row<49||tempStonePosition.row>56){
        } else{
            stonePosition = tempStonePosition.copy()
            kingPosition = tempKingPosition.copy()
        }
//        System.out.println(" kingPosition : ${kingPosition.column.toChar()}   ${kingPosition.row.toChar()}")
//        System.out.println(" stonePosition : ${stonePosition.column.toChar()}   ${stonePosition.row.toChar()}")

    }
    System.out.println("${kingPosition.column.toChar()}${kingPosition.row.toChar()}")
    System.out.println("${stonePosition.column.toChar()}${stonePosition.row.toChar()}")
}

