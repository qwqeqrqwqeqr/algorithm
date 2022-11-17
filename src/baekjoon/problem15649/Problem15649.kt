package baekjoon.problem15649

import java.io.BufferedWriter
import java.io.OutputStreamWriter

var N =0
var M =0
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }.toList()

    N = input[0]; M= input[1]
    dfs(0, IntArray(M,{Int.MAX_VALUE}))
    bufferedWriter.flush()
}


fun dfs(depth: Int, array: IntArray){
    if(depth==M){ array.forEach { bufferedWriter.write("$it ") }; bufferedWriter.newLine(); return }
    for(i in 1 .. N){
        if(depth!=0){ if(checkDuplication(depth,array,i)){continue} }
        val newArray =array.clone()
        newArray[depth] = i
        dfs(depth+1,newArray)
    }
}


fun checkDuplication(depth:Int, array: IntArray, target: Int) :Boolean{
    for(j in 0 until  depth){
        if(array[j] == target) {return true}
    }
    return false
}