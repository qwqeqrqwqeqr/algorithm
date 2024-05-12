package baekjoon.problem2440

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n =readLine().toInt()
    for(i in 0 until  n){
        for(j in i+1 .. n){
                print("*")
        }
        println()
    }
}