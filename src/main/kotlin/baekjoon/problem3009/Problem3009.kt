package baekjoon.problem3009

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var a = listOf<Int>()
    var b = listOf<Int>()
    repeat(3) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        a= a.plus(x)
        b= b.plus(y)
    }
    println("${a.groupBy { it }.filter { it.value.size % 2 != 0 }.keys.first()} " +
            "${b.groupBy { it }.filter { it.value.size % 2 != 0 }.keys.first()}"
    )
}