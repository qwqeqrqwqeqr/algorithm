package baekjoon.problem1026

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var A : List<Int> = readLine().split(' ').map { it.toInt() }
    var B : List<Int> = readLine().split(' ').map { it.toInt() }
    var sum =0
    A= A.sorted()
    B=B.sortedDescending()

    for(i in A.indices){
        sum+=A[i]*B[i]
    }
    println(sum)
}