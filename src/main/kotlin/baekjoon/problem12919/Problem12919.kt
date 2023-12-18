package baekjoon.problem12919
var answer = ""
var flag = false
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val target = readLine().apply { answer= this }
    val source = readLine()
    backTracking(source)
    if(flag) println(1) else println(0)
}

fun backTracking(source: String) {
    if(source.length < answer.length){
        return
    }
    if(source == answer){
        flag=true
        return
    }
    if(source.first()=='B'){
        backTracking(source.drop(1).reversed())
    }
    if(source.last()=='A'){
        backTracking(source.dropLast(1))
    }
}
