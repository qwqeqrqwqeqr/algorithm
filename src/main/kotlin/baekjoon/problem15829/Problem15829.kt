package baekjoon.problem15829



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine()
    val prime = 1234567891
    var pow = 1L
    println(readLine().map { (it.code - 'a'.code) + 1L }.reduce { acc, i ->
        pow = pow * 31 % prime
        (acc + i * pow % prime) % prime
    })
}