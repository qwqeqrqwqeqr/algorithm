package baekjoon.problem1247

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.math.BigInteger

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    repeat(3) {
        var sum = BigInteger("0")
        repeat(readLine().toInt()) {
            sum = sum.plus(readLine().toBigInteger())
        }
        bufferedWriter.append(
            "${
                if (sum > BigInteger("0")) "+"
                else if (sum < BigInteger("0")) "-"
                else 0
            }\n"
        )
    }
    bufferedWriter.flush()

}

