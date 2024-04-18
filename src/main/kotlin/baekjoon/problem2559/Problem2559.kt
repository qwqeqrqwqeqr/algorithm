package baekjoon.problem2559

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(n)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        array[index] = i
    }
    var sum = array.slice(0 until k).sum()
    var max = sum
    for (i in 1 .. array.size - k) {
        sum -= array[i - 1]
        sum += array[i + k -1]
        max = Math.max(sum, max)
    }
    println(max)
}


/**
 * 10 1
 * 1 2 3 4 5 6 7 8 9 10
 */