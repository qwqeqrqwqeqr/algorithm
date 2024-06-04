package baekjoon.problem10757

import java.math.BigInteger

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().split(" ").also {
        println(BigInteger(it[0]).plus(BigInteger(it[1])))
    }
}