package baekjoon.problem20529

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        readLine()
        var sum = Int.MAX_VALUE
        val list = readLine().split(" ")

        if(list.size>32){
            bufferedWriter.append("0\n")
        }
        else {
            for (i in list.indices) {
                for (j in 0 until i) {
                    for (k in 0 until j) {
                        var count = 0
                        count += list[i].filterIndexed { index, c -> list[j][index] != c }.count()
                        count += list[j].filterIndexed { index, c -> list[k][index] != c }.count()
                        count += list[k].filterIndexed { index, c -> list[i][index] != c }.count()
                        sum = count.coerceAtMost(sum)
                    }
                }
            }
            bufferedWriter.append("$sum\n")
        }
    }
    bufferedWriter.flush()
}