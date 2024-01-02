package baekjoon.problem1003

import java.io.BufferedWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = Array(41) { Fibonacci(value = it, 0, 0) }.also {
        it[0] = Fibonacci(0, 1, 0)
        it[1] = Fibonacci(1, 0, 1)
    }
    for (i in 2..array.lastIndex) {
        array[i] = Fibonacci(
            value = array[i - 1].value + array[i - 2].value,
            callOne = array[i - 1].callOne + array[i - 2].callOne,
            callZero = array[i - 1].callZero + array[i - 2].callZero,)
    }

    val bufferedWriter:BufferedWriter= System.out.bufferedWriter()

    repeat(readLine().toInt()) {
        array[readLine().toInt()].apply {
            bufferedWriter.append("${this.callZero} ${this.callOne}\n")

        }
    }
    bufferedWriter.flush()
}

data class Fibonacci(val value: Int, val callZero: Int, val callOne: Int)