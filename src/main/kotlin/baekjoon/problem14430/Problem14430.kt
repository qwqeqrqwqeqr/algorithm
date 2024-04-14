package baekjoon.problem14430

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = Array(n + 1) { IntArray(m + 1) }

    repeat(n) { r ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { c, value ->
            array[r + 1][c + 1] = value
        }
    }

    for (i in 1 .. n) {
        for (j in 1 .. m) {
            array[i][j] += Math.max(array[i - 1][j], array[i][j - 1])
        }
    }

   println(array[n][m])
}