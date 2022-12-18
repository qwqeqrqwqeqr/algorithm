package baekjoon.problem11758

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    lateinit var p1: Pair<Int, Int>
    lateinit var p2: Pair<Int, Int>
    lateinit var p3: Pair<Int, Int>

    readLine().split(" ").map { it.toInt() }.let { p1 = Pair(it[0], it[1]) }
    readLine().split(" ").map { it.toInt() }.let { p2 = Pair(it[0], it[1]) }
    readLine().split(" ").map { it.toInt() }.let { p3 = Pair(it[0], it[1]) }


    val result = (p1.first * p2.second) + (p2.first * p3.second) + (p3.first * p1.second) - (p2.first * p1.second + p3.first * p2.second + p1.first * p3.second)


    if (result > 0) {
        println(1)
    } else if (result < 0) {
        println(-1)

    } else {
        println(0)
    }


}