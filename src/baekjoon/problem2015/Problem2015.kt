package baekjoon.problem2015

import java.util.*
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N,K) = readLine().split(" ").map { it.toLong() }
    var count =0L
    val list = arrayListOf<Long>().also { it.add(0) }
    val st =  StringTokenizer(readLine())
    for(i in 1..N) {
        list.add(list[(i - 1).toInt()] + Integer.parseInt(st.nextToken()))
    }
    val map = HashMap<Long, Long>().also { it[0]=1 }
    for(i in 1..N) {
        count+=map.getOrDefault(list[i.toInt()]-K, 0);
        map[list[i.toInt()]] = map.getOrDefault(list[i.toInt()],0)+1;
    }
    println(count)
}
