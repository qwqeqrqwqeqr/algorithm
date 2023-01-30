package baekjoon.problem15657

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

var n = 0
var m = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(N) { 0 }
    readLine().split(" ").map { it.toInt() }.sorted().forEachIndexed { index, i ->
        array[index] = i
    }
    m = M; n = N

    dfs(array, arrayListOf(),0)
    bufferedWriter.flush()
}

fun dfs(array: IntArray, depth: ArrayList<Int>,index:Int) {
    if (depth.size == m) {
        bufferedWriter.append(depth.joinToString(" ") + "\n")
        return
    }
    for (i in index until n) {
        depth.add(array[i])
        dfs(array, depth,i)
        depth.removeLast()
    }
}