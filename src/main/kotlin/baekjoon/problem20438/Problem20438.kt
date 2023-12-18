package baekjoon.problem20438

import java.io.BufferedWriter
import java.io.OutputStreamWriter
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, K, Q, M) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(N + 3) { 1 }
    val kList = readLine().split(" ").map { it.toInt() }
    readLine().split(" ").map { it.toInt() }.subtract(kList.toSet()).onEach {
        var count = 1
        while (it * count < N + 3) {
            array[it * count] = 0
            count++
        }
    }
    kList.forEach { array[it]=1 }
    val list = arrayListOf<Int>().also { list -> repeat(3){list.add(0) }}
    for(i in 3 until N+3) {
        list.add(list[i - 1] + array[i])
    }
    repeat(M) {
        val range = readLine().split(" ").map { it.toInt() }.let { Pair(it[0]-1, it[1]) }
        bufferedWriter.append((list[range.second] - list[range.first]).toString() + "\n")
    }
    bufferedWriter.flush()
}

