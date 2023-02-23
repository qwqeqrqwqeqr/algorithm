package baekjoon.problem21318

import java.io.BufferedWriter
import java.io.OutputStreamWriter
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val array  = IntArray(N+1) { -1 }
    val list = arrayListOf<Int>().also { it.add(0) }
    readLine().split(" ").map { it.toInt() }.apply { list.addAll(this) }
    for(i in 1..N) {
        val temp = if( list[i] < list[i-1] ) 1 else 0
        array[i]= temp+ if(array[i-1]==-1) 0 else array[i-1]
    }
    repeat(readLine().toInt()){
        val answer = readLine().split(" ").map { it.toInt() }.let { Pair(it[0],it[1]) }
        bufferedWriter.append(( array[answer.second]-array[answer.first]).toString()+"\n")
    }
    bufferedWriter.flush()
}