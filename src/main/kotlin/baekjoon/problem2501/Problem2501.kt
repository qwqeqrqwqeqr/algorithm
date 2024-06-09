package baekjoon.problem2501

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    var count = 0
    for (i in 1..n) {
        if (n % i == 0) count+=1
        if(count==k){
            println(i)
            break
        }
    }
    if(count<k) println(0)
}