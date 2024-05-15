package baekjoon.problem10811

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(n + 1) { it }
    repeat(m){
        val (a,b) = readLine().split(" ").map {it.toInt() }
        array.reverse(a,b+1)
    }
    println(array.drop(1).joinToString(" "))
}