package baekjoon.problem2163

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   println(readLine().split(" ").map { it.toInt() }.let { (it[0]*it[1])-1 })
}