package baekjoon.problem1100

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = Array(8) { BooleanArray(8) }
    repeat(8) { row ->
        readLine().forEachIndexed { column, value ->
            map[row][column] = if (value == 'F') true
            else false
        }
    }
    var count = 0
    for (i in 0 until 8) {
        for (j in 0 until 8) {
            if (i % 2 == 0 && j % 2 == 0 && map[i][j]) count += 1
            else if (i % 2 == 1 && j % 2 == 1 && map[i][j]) count += 1
        }
    }
    println(count)
}