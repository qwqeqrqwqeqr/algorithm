package baekjoon.problem10093

import kotlin.math.abs


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toLong() }
    if(a>b){
        println(abs(b-a) -1)
        println((b+1 until  a).joinToString(" "))

    }else if(b>a){
        println(abs(b-a) -1)
        println((a+1 until  b).joinToString(" "))
    }else{
        println(0)
    }
}