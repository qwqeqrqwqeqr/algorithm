package baekjoon.problem10610

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine()
    if (input.none { it == '0' } || input.sumOf { it.digitToInt() } % 3 != 0) {
        println(-1)
    } else {
        println(input.toMutableList().sortedByDescending { it.digitToInt() }.joinToString(""))
    }
}


