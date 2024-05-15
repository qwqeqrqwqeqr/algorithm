package baekjoon.problem2563

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = Array(100) { BooleanArray(100) { false } }
    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ").map { it.toInt() - 1 }

        for (i in a until  a + 10) {
            map[i].fill(element = true, fromIndex = b, toIndex = b + 10 )
        }
    }
    println(map.sumOf { it.count { it } })
}