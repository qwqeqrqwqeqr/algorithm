package baekjoon.problem10951


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
         readLine()?.let { println(it.split(" ").map { it.toInt() }.let { it[0] + it[1] }) } ?: break
    }
}