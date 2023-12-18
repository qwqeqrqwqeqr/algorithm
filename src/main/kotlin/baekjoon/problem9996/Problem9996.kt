package baekjoon.problem9996

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val pattern = readLine()
    val first = pattern.substring(0 until  pattern.indexOf("*"))
    val last = pattern.substring(pattern.indexOf("*")+1 until  pattern.length)
    repeat(N){
        val string =readLine()
        val f =string.take(first.length)
        val l =string.takeLast(last.length)
        if(first==f&&last==l&& (first.length+last.length <= string.length))  bufferedWriter.append("DA\n") else bufferedWriter.append("NE\n")
    }
    bufferedWriter.flush()
}


//1
//a*a
//a