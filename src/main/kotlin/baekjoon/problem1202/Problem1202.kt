package baekjoon.problem1202

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val jewel = Array<Jewel?>(n) { null }
    val back = IntArray(k)
    val priorityQueue = PriorityQueue<Int>() { o1, o2 -> o2 - o1 }
    var result = 0L
    var index = 0
    repeat(n) {
        val (m, v) = readLine().split(" ").map { it.toInt() }
        jewel[it] = Jewel(m, v)
    }
    repeat(k) {
        back[it] = readLine().toInt()
    }
    jewel.sortBy { it!!.weight }
    back.sort()
    for (i in 0 until k) {
        while (index < n) {
            if (jewel[index]!!.weight <= back[i])
                priorityQueue.add(jewel[index]!!.value)
            else break
            index += 1
        }
        if (priorityQueue.isNotEmpty()) result += priorityQueue.poll()
    }
    println(result)
}

data class Jewel(
    val weight: Int,
    val value: Int
)

