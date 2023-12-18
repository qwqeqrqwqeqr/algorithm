package baekjoon.problem19949

var answer = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }

    for(i in 1 .. 5){
        dfs(1,input,i,1, i.checkAnswer(input[0]))
    }
    println(answer)
}

fun dfs(depth :Int, list: List<Int>, lastIndex :Int, count : Int,answerCount:Int){
    if(count>=3){ return }
    if(depth>=10){
        if( answerCount>=5){ answer+=1}
        return
    }
    for(i in 1 .. 5){
        dfs(depth+1,list, i , if(lastIndex==i) count+1 else 1, answerCount+i.checkAnswer(list[depth]))
    }
}

fun Int.checkAnswer(answer :Int) : Int = if(this == answer) 1 else 0
