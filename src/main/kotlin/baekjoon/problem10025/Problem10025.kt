package baekjoon.problem10025

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(5_000_001) { 0 }
    repeat(n) {
        val (g, x) = readLine().split(" ").map { it.toInt() }
        array[x] = g
    }

    var start = 0
    var end = 2 * k
    var sum = array.slice(start..end).sum()

    var maxValue = sum

    while (end < array.size-1) {
        sum -= array[start]
        start += 1
        end += 1
        sum += array[end]
        if(sum > maxValue) maxValue =sum
    }
    println(maxValue)
}


