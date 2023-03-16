package baekjoon.problem1747

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.sqrt


val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var answer =0
    for(i in readLine().toInt() until  1_000_000){
        if((isPrime(i))&& (i.toString().isPalindrome())){ answer=i; break }
    }
    if(answer==0) bufferedWriter.append("1003001") else bufferedWriter.append(answer.toString())
    bufferedWriter.flush()
}

fun isPrime(number: Int) : Boolean{
    if (number <= 1) { return false }
    for (i in  2 .. sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) { return false } }
    return true
}
fun String.isPalindrome():Boolean{ return this == this.reversed() }