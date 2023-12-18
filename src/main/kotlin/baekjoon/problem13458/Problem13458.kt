package baekjoon.problem13458


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().split(" ").map { it.toLong() }
    val takerList =  readLine().split(" ").map { it.toLong() }.toList()
    val input = readLine().split(" ").map { it.toLong() }
    var count = N[0]

    takerList.asSequence().map { it-input[0] }.filter { it>0 }.forEach {
        count+= kotlin.math.ceil(it / input[1].toDouble()).toLong()
    }
    println(count)
}