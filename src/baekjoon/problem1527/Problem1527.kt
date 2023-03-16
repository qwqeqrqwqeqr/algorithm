package baekjoon.problem1527


var answer =0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (A,B) = readLine().split(" ").map { it.toLong() }
    for(i in setOf<Long>(4L,7L)){ dfs(A,B,i) }
    println(answer)
}

fun dfs(A:Long,B:Long,value:Long){
    if(value>B){ return }
    if(value>=A){ answer++ }
    dfs(A,B,value*10+4)
    dfs(A,B,value*10+7)
}
