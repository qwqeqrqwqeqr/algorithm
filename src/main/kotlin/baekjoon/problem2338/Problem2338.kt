package baekjoon.problem2338

import java.math.BigInteger

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val a = BigInteger(readLine())
    val b = BigInteger(readLine())
    println(a+b)
    println(a-b)
    println(a*b)
}