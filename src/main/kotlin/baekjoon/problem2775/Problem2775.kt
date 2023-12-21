package baekjoon.problem2775

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = Array(15) { IntArray(15) { 0 } }
    for (i in 0 until 15) {
        array[0][i] = i
    }
    for (i in 1 until  array.size) {
        for (j in 1 until  array.size) {
            for (k in 1 .. j) {
                array[i][j] += array[i - 1][k]
            }
        }
    }

    repeat(readLine().toInt()) {
        val k = readLine().toInt()
        val n = readLine().toInt()
        println(array[k][n])
    }

}