package baekjoon.problem1712

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toLong() }
    var count = 1
    if(b>=c) println(-1)
    else {
        while (true) {
            if (a + count * b < c * count) break
            count += 1
        }
        println(count)
    }
}