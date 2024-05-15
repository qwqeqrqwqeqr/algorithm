package baekjoon.problem10817

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
     readLine().split(" ").map { it.toInt() }.sorted().also {
         println(it[1])
     }
}