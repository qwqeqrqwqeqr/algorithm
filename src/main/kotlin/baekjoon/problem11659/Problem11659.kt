package baekjoon.problem11659

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val (N,M) = readLine().split(" ").map { it.toInt() }
    val list = arrayListOf<Int>().also { it.add(0) }
    val st =  StringTokenizer(readLine())
    for(i in 1..N) { list.add(list[i - 1] + Integer.parseInt(st.nextToken())) }
    repeat(M){ getSumArea(list,readLine().split(" ").map { it.toInt() }.let { Pair(it[0]-1,it[1]) }) }
    bufferedWriter.flush()
}


fun getSumArea(list: ArrayList<Int>, range: Pair<Int, Int>, ){
    bufferedWriter.append((list[range.second]-list[range.first]).toString()+"\n")
}


