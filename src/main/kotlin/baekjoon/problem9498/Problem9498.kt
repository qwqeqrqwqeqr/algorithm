package baekjoon.problem9498

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
   println(readLine().toInt().let {
        when (it) {
            in 90 .. 100 -> 'A'
            in 80 .. 89 -> 'B'
            in 70 .. 79 ->'C'
            in 60 .. 69 ->'D'
            else -> 'F'
        }
    })
}