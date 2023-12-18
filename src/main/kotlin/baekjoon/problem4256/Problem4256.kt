package baekjoon.problem4256

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter((System.out)))
    val T = readLine().toInt()
    repeat(T) {
        val N = readLine().toInt()
        val preOrder = readLine().trim().split(" ").map { it.toInt() }.toList()
        val inOrder = readLine().trim().split(" ").map { it.toInt() }.toList()
        postOrder(0, 0, N, preOrder, inOrder,bw)
        bw.append('\n')
    }
    bw.flush()
}

fun postOrder(root: Int, start: Int, end: Int, preOrder: List<Int>, inOrder: List<Int>, bw: BufferedWriter) {
    for (i in start until end) {
        if (inOrder[i] == preOrder[root]) {
            postOrder(root + 1, start, i, preOrder, inOrder, bw)
            postOrder(root + i+1-start, i+1, end, preOrder, inOrder, bw)
            bw.append(preOrder[root].toString())
            bw.append(" ")
        }
    }
}

