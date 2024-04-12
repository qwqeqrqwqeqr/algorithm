package baekjoon.problem1629

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toLong() }
    println(calc(a, b, c))
}


fun calc(a: Long, b: Long, c: Long): Long {
    return if (b == 1L) a % c
    else {
        val result = calc(a, b / 2, c) % c
        if (b % 2 == 0L) (result * result) % c
        else (((result * result) % c) * (a % c)) % c
    }
}
