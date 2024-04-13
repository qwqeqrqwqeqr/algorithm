package baekjoon.problem9656

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(if (readLine().toInt() % 2 == 0) "SK" else "CY")
}

/**
 * SK -> CY
 * 1 -> CY
 * 2 -> SK
 * 3 -> CY
 * 4 -> SK
 * 5 -> CY
 * 6 -> SK
 * 7 -> CY
 */