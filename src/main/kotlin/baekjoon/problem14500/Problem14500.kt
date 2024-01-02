package baekjoon.problem14500

var N = 0
var M = 0
var max = Int.MIN_VALUE

val tetromino = arrayOf(
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1)),
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(0, 3)),
    arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0)),
    arrayOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(2, 1)),
    arrayOf(Pair(1, 0), Pair(0, 1), Pair(1, 1), Pair(2, 0)),
    arrayOf(Pair(1, 0), Pair(1, 1), Pair(0, 1), Pair(0, 2)),
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(1, 2)),
    arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(2, 1)),
    arrayOf(Pair(0, 1), Pair(1, 1), Pair(2, 0), Pair(2, 1)),
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(2, 0)),
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(2, 1)),
    arrayOf(Pair(1, 0), Pair(0, 1), Pair(1, 1), Pair(1, 2)),
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 1)),
    arrayOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(1, 2)),
    arrayOf(Pair(1, 0), Pair(1, 1), Pair(1, 2), Pair(0, 2)),
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 0)),
    arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 2)),
    arrayOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(2, 0)),
    arrayOf(Pair(1, 0), Pair(0, 1), Pair(1, 1), Pair(2, 1))
)


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply { N = get(0); M = get(1) }
    val array = Array(N) { IntArray(M) { 0 } }
    repeat(N) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            array[it][index] = i
        }
    }
    for (i in 0 until N) {
        for (j in 0 until M) {
            tetromino.forEach { list ->
                if (list.count { checkBound(it.copy(first = it.first + i, second = it.second + j)) } == 4) max =
                    max.coerceAtLeast(list.sumOf { array[it.first + i][it.second + j] })
            }
        }
    }
    println(max)
}

fun checkBound(coordinate: Pair<Int, Int>): Boolean {
    return (0 <= coordinate.second && 0 <= coordinate.first && coordinate.second < M && coordinate.first < N)
}