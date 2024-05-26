package baekjoon.problem1271

import java.math.BigInteger

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().split(" ").also {
        val a= BigInteger(it[0])
        val b= BigInteger(it[1])
        println(a.divide(b))
        println(a.mod(b))
    }
}