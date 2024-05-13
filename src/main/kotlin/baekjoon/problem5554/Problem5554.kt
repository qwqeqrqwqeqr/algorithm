package baekjoon.problem5554

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var sum = 0
    repeat(4){
        sum+= readLine().toInt()
    }
    println("${sum/60}")
    println("${sum%60}")
}