package baekjoon.problem26099

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var n = readLine().toLong()
    var count = 0L
    while (n > 0L) {
        if (n % 5L == 0L) break
        n -= 3L
        count += 1L
    }
    println(if (n < 0) -1 else count + n / 5L)
}