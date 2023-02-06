package baekjoon.problem1092

import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val limit = readLine().split(" ").map { it.toInt() }.sortedDescending()
    val M = readLine().toInt()
    val box = ArrayList<Int>()
    readLine().split(" ").map { it.toInt() }.sortedDescending().forEach {
        box.add(it)
    }
    if(box.first()>limit.first()){
        println(-1)
    }
    else{
        var time =0
        while (box.isNotEmpty()){
            for(i in limit.indices){
                for(j in box.indices){
                    if(box.isNotEmpty() && limit[i]>=box[j]){
                        box.remove(box[j])
                        break
                    }
                }
            }
            time++
        }
        println(time)
    }

}


/*
3
10 6 5
11
6 8 9 6 8 6 9 6 8 6 9
 */