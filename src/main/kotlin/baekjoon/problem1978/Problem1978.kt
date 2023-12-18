package baekjoon.problem1978

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine()
    println( readLine().split(" ").map { it.toInt() }.filter { isPrime(it) }.count())
}

fun isPrime(number: Int): Boolean = number > 1 && (2 until number).none { number % it == 0 }
