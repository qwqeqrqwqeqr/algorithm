package baekjoon.problem11382
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   val (A,B,C) = readLine().split(" ").map { it.toLong() }
    println(A+B+C)
}