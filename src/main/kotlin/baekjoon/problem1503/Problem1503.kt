package baekjoon.problem1503

import kotlin.math.abs
var N =0
var M =0
var answer =Int.MAX_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply {
        N=this[0]; M=this[1]
    }
    val arrayList = BooleanArray(1002){false}
    val set = readLine()
    if(set!= ""){
        set.split(" ").map { it.toInt() }.forEach { arrayList[it]= true }
    }

    for(i in 1 until 1002){
        if(!arrayList[i]){
            for(j in 1 until 1002){
                if(!arrayList[j]) {
                    for (k in 1 until 1002) {
                        if(!arrayList[k]){
                            answer = Math.min(answer, abs(N-i*j*k))
                        }
                    }
                }
            }
        }
    }
    println(answer)
}