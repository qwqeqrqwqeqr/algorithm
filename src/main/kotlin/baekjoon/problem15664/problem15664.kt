package baekjoon.problem15664

import java.io.BufferedWriter
import java.io.OutputStreamWriter
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

var m = 0
var n = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N,M) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(N) { 0 }
    val visited = BooleanArray(N){false}
    readLine().split(" ").map { it.toInt() }.sorted().forEachIndexed { index, i ->
        array[index]=i
    }
    m = M; n = N

    dfs(visited, array, arrayListOf(),0)
    bufferedWriter.flush()
}

fun dfs(visited: BooleanArray, array: IntArray, depth: ArrayList<Int>,index:Int) {
    if(depth.size== m){
        bufferedWriter.append(depth.joinToString(" ")+"\n")
        return
    }
    var before = Int.MIN_VALUE
    for(i in index until n){
        if(!visited[i] && before!=array[i]){
            visited[i]=true
            before=array[i]
            depth.add(array[i])
            dfs(visited, array, depth,i)
            depth.removeLast()
            visited[i]=false
        }
    }
}