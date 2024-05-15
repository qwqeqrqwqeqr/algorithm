package baekjoon.problem10810

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(n + 1)
    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        array.fill(element = c, fromIndex = a, toIndex = b+1)
    }
    println(array.drop(1).joinToString(" "))
}