package baekjoon.problem15652

var N =0
var M =0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }.toList()
    N = input[0]; M= input[1]
    dfs(0, IntArray(M,{Int.MAX_VALUE}))
}


fun dfs(depth: Int, array: IntArray){
    if(depth==M){ array.forEach { print("$it "); };println(); return }
    for(i in 1 .. N){
        if(depth!=0){ if(array[depth-1] > i){ continue } }
        val newArray =array.clone()
        newArray[depth] = i
        dfs(depth+1,newArray)
    }
}