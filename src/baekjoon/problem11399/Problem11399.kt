package baekjoon.problem11399

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val withdrawalList = readLine().split(' ').map { it.toInt() }.let { it.sorted() }
    var sum =0
    var waitTime = 0
    withdrawalList.forEach {
        waitTime += it
        sum += waitTime
    }
    println(sum)
}
