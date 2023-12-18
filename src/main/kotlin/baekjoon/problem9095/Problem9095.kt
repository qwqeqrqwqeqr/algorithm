package baekjoon.problem9095

import kotlin.math.max

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var max = 0
    var inputList: ArrayList<Int> = arrayListOf()
    val sum: MutableMap<Int,Int> = mutableMapOf()
    repeat(N) {
        inputList.add(readLine().toInt().also { max = max(it,max) })
    }

    sum[1] = 1 // 1
    sum[2] = 2 //11 2
    sum[3] = 4 //111 12 21 3

    for(i in 4..max){ sum.put(i,sum.getValue(i-1) +sum.getValue(i-2)+sum.getValue(i-3)) }

    inputList.forEach { println(sum.getValue(it)) }
}

/*
 4 => 7
 5 => 13
*/
