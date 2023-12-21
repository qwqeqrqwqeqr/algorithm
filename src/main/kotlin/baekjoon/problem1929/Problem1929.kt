package baekjoon.problem1929

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val (min, max) = readLine().split(" ").map { it.toInt() }
    val array = BooleanArray(max + 1) { true }.also {
        it[0] = false
        it[1] = false
    }
    for (i in 0..max) {
        if (array[i]) {
            for (j in 2..max / i) {
                array[i * j] = false
            }
        }
    }
    array.forEachIndexed { index, b -> if (b && index in (min..max)) bufferedWriter.append("${index}\n") }
    bufferedWriter.flush()
}