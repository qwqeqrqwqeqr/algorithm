package baekjoon.problem1987

var R = 0
var C = 0

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)

val map = Array(21) { CharArray(21) }
val visited = Array(21) { BooleanArray(21) { false } }
val set = HashSet<Char>()
var max = Int.MIN_VALUE

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.also {
        R = it[0]
        C = it[1]
    }

    repeat(R) { row ->
        readLine().forEachIndexed { column, value ->
            map[row][column] = value
        }
    }

    visited[0][0] = true
    set.add(map[0][0])
    backTracking(0 to 0, 1)

    println(max)
}


fun backTracking(position: Pair<Int, Int>, depth: Int) {

    max = depth.coerceAtLeast(max)

    for (i in 0..3) {
        val target = dy[i] + position.first to dx[i] + position.second
        if (checkBound(
                target.first,
                target.second
            ) && !visited[target.first][target.second] && !set.contains(map[target.first][target.second])
        ) {
            visited[target.first][target.second] = true
            set.add(map[target.first][target.second])
            backTracking(target, depth + 1)
            set.remove(map[target.first][target.second])
            visited[target.first][target.second] = false
        }
    }
}

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < C && y < R)
}