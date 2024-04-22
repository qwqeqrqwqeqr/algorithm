package baekjoon.problem3273

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.sorted()
    val x = readLine().toInt()

    var start = 0
    var end = n - 1
    var count = 0

    while (start < end) {
        val sum = list[start] + list[end]
        if (sum == x) count += 1
        if (sum >= x) end -= 1
        else start += 1
    }

    println(count)

}