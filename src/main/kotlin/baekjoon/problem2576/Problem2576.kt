package baekjoon.problem2576

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var min = Int.MAX_VALUE
    var sum =0
    repeat(7){
        val n = readLine().toInt()
        if(n%2==1){
            min =Math.min(min,n)
            sum+=n
        }
    }
    if(sum==0) println(-1)
    else {
        println(sum)
        println(min)
    }
}