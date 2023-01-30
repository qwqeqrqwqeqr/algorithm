package baekjoon.problem15656

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

    dfs(array, arrayListOf())
    bufferedWriter.flush()
}

fun dfs(array: IntArray, depth: ArrayList<Int>) {
    if (depth.size == m) {
        bufferedWriter.append(depth.joinToString(" ") + "\n")
        return
    }
    for (i in 0 until n) {
        depth.add(array[i])
        dfs(array, depth)
        depth.removeLast()
    }
}