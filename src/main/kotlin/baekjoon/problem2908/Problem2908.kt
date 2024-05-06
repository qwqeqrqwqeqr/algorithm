package baekjoon.problem2908

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.reversed().toInt() }.also {
       println(if(it[0]>it[1]) it[0] else it[1])
    }

}