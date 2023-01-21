package baekjoon.problem14501


var max= 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().trim().toInt()
    val array= Array(input+1) { Consulting(0,0) }
    repeat(input){
        readLine().split(" ").map { it.trim().toInt() }.apply {
            array[it+1]=(Consulting(this[0],this[1]))
        }
    }
    for(i in 1 ..  input){
        if(i+array[i].day<=input+1){
            dfs(input,array,i+array[i].day,array[i].income)
        }
    }
    println(max)
}


fun dfs(N:Int,consulting: Array<Consulting>, depth:Int, sum:Int){
    if(depth>N){
        max= sum.coerceAtLeast(max)
        return
    }
    if(depth+consulting[depth].day>N+1){
        max= sum.coerceAtLeast(max)
    }else{
        dfs(N,consulting,depth+consulting[depth].day,sum+consulting[depth].income)
    }
    if(depth+1>N+1){
        max= sum.coerceAtLeast(max)
    }else{
        dfs(N,consulting,depth+1,sum)
    }
}

data class Consulting(val day:Int,  val income:Int)