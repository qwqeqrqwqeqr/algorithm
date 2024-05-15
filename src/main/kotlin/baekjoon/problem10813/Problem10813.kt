package baekjoon.problem10813

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(n + 1) { it }
    repeat(m) {
        val (a,b)= readLine().split(" ").map { it.toInt() }
        array[a] = array[b].also { array[b] = array[a] }
    }
    println(array.drop(1).joinToString(" "))
}