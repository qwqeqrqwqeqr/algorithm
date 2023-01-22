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
    //모든 일자에 대해서 상담을 진행하는 경우를 가정함
    for(i in 1 ..  input){
        if(i+array[i].day<=input+1){
            dfs(input,array,i+array[i].day,array[i].income)
        }
    }
    println(max)
}


fun dfs(N:Int,consulting: Array<Consulting>, depth:Int, sum:Int){
    //이미 퇴사를 했을때
    if(depth>N){
        max= sum.coerceAtLeast(max)
        return
    }
    //이 상담을 진행할 경우 퇴사가 연장될때
    if(depth+consulting[depth].day>N+1){
        max= sum.coerceAtLeast(max)
    }else{
        dfs(N,consulting,depth+consulting[depth].day,sum+consulting[depth].income)
    }
    //다음날로 넘어갈때 퇴사일경우
    if(depth+1>N+1){
        max= sum.coerceAtLeast(max)
    }else{
        dfs(N,consulting,depth+1,sum)
    }
}

data class Consulting(val day:Int,  val income:Int)