package baekjoon.problem10986

import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    var count = 0L
    val list = arrayListOf<Int>().also { it.add(0) }
    val map = HashMap<Long, Long>()

    val st = StringTokenizer(readLine())
    for (i in 1..N) {
        list.add((list[(i - 1)] + Integer.parseInt(st.nextToken())) % M)
        if (list[i] == 0) {
            count += 1
        }
        map[list[i].toLong()] = map.getOrDefault(list[i].toLong(), 0L) + 1
    }
    for (i in 0 until M) {
        val target = map.getOrDefault(i.toLong(), 0L)
        count += target * (target - 1) / 2
    }
    println(count)
}

