package baekjoon.problem2661

import kotlin.system.exitProcess


var target = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    target = readLine().toInt()
    dfs(0,"")
}

fun dfs(depth:Int,sum:String){
    if(depth== target){
        println(sum)
        exitProcess(0)
    }
    for(i in 1 .. 3){
        if(check(sum+i.toString())){
            dfs(depth+1,sum+i)
        }
    }
}

fun check(sum:String):Boolean{
    for(i in 1 .. sum.length/2){
        val pre= sum.substring(sum.length-i until sum.length)
        val next =sum.substring(sum.length-i-i until sum.length-i)
        if(pre==next){ return false }
    }
    return true
}
