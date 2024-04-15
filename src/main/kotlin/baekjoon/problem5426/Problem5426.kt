package baekjoon.problem5426

import kotlin.math.sqrt

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val cypherText = readLine()
        val letter = sqrt(cypherText.length.toDouble()).let { size ->
            Array(size.toInt()) { CharArray(size.toInt()) }
        }
        var count = 0
        for (i in letter.indices) {
            for (j in letter.indices) {
                letter[i][j] = cypherText[count++]
            }
        }
        for (i in letter.size-1 downTo 0) {
            for (j in letter.indices) {
                print(letter[j][i])
            }
        }
        println()
    }
}