package baekjoon.problem18511

/*
100000000 1
1

15 2
9

657 3
1 5 7

보류 */

import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter((System.out)))
    val input = readLine().split(" ")
    val number = readLine().split(" ").map { it.toInt() }.toList().sorted()
    val target = input[0].toList().map { Character.getNumericValue(it) }.toMutableList()


    for (j in number.indices) {
        if (target.first() < number[j]) {
            if (j - 1 >= 0) {
                bw.append("${number[j - 1]}")
            }
            repeat(target.size - 1 ) {
                bw.append("${number.last()}")
            }
            bw.flush()
            return@with
        } else if (target.first() == number[j]) {
           target.forEach {

           }
        }
    }
    bw.flush()
}
