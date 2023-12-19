package baekjoon.problem2231

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    repeat((1 .. input).count()) {
         if(input == it + it.toString().map { it.digitToInt() }.sum()){
             println(it)
             return@with
         }
    }
    println(0)
}