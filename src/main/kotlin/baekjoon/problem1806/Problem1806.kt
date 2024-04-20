package baekjoon.problem1806

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map { it.toInt() }
    val array = readLine().split(" ").map { it.toInt() }.toTypedArray()

    var min = Int.MAX_VALUE
    var sum = array[0]
    var start = 0
    var end = 0
    while (end in start  ..  n) {
        if (sum >= s) {
            min = Math.min(end - start + 1, min)
        }

        if (sum >= s) {
            sum -= array[start]
            start += 1
        } else {
            end += 1
            if(end>=n) break
            sum += array[end]
        }
    }
    println(if (min == Int.MAX_VALUE) 0 else min)
}

