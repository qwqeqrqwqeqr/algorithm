package baekjoon.problem11660

import java.io.BufferedWriter
import java.io.OutputStreamWriter
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N,M) = readLine().split(" ").map { it.toInt() }
    val map = Array(N+1) { IntArray(N+1) { 0 } }
    repeat(N){
        val list = readLine().split(" ").map { it.toInt() }
        for(i in 1..N) {
            map[it+1][i] =  map[it][i]+ map[it+1][i-1] + list[i-1] - map[it][i-1]
        }
    }
    repeat(M){
        val (x1,y1,x2,y2) = readLine().split(" ").map { it.toInt() }
        bufferedWriter.append((map[x2][y2]-map[x1-1][y2]-map[x2][y1-1]+map[x1-1][y1-1]).toString()+"\n")
    }
    bufferedWriter.flush()
}