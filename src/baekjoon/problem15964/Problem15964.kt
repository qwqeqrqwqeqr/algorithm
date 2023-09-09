package baekjoon.problem15964


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toLong() }.apply {
        println((this[0]+this[1]) * (this[0]-this[1]))
    }
}


