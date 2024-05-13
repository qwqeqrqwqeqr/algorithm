package baekjoon.problem5717

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true){
        val (a,b) = readLine().split(" ").map { it.toInt() }
        if(a==b && a==0) break
        println(a+b)
    }
}