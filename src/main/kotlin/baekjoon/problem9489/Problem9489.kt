package baekjoon.problem9489

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.ArrayList
import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val input = readLine().split(' ').map { it.toInt() }.toIntArray()
        if (input[0] == 0 && input[1] == 0) { break }
        val inputList = readLine().split(' ').map { it.toInt() }.toIntArray()
        var array = Array(6){0}
        val parentList = ArrayList<Parent>()
        array[0]=1;array[1]=1
        for (i in inputList.indices) {
            if (inputList[i] == input[1]) {
                array[5] = i
            }
            if (abs(inputList[array[3]] - inputList[i]) <= 1) {
                parentList.add(Parent(array[0], array[4]))
            } else {
                array[4] += 1
                array[1]--
                if (array[1] == 0) {
                    array[0] += 1
                    parentList.add(Parent(array[0], array[4]))
                    array[1] = array[2]
                    array[2] = 0
                } else {
                    parentList.add(Parent(array[0], array[4]))
                }
            }
            array[2] += 1; array[3] = i
        }
        bw.write(
            "${
                parentList.filter { parentList[array[5]].group != it.group }
                    .count { parentList[array[5]].depth == it.depth }
            } \n"
        )
    }
    bw.flush()
    bw.close()
}

data class Parent(val depth: Int, val group: Int)




