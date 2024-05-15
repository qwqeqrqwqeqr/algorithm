package baekjoon.problem10430

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (A, B, C) = readLine().split(" ").map { it.toInt() }
    println((A + B) % C)
    println(((A % C) + (B % C)) % C)
    println((A * B) % C)
    println(((A % C) * (B % C)) % C)
}