package baekjoon.problem2167

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(m) }
    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            array[row][column] = value
        }
    }
    repeat(readLine().toInt()) {
        val (i, j, x, y) = readLine().split(" ").map { it.toInt() }
        getArraySum(array, i-1, j-1, x-1, y-1)
    }
}


fun getArraySum(array: Array<IntArray>, i: Int, j: Int, x: Int, y: Int) {
    var sum = 0
    for (r in i..x) {
        for (c in j..y) {
            sum += array[r][c]
        }
    }
    println(sum)
}