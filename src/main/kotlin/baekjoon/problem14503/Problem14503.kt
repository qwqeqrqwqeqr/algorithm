package baekjoon.problem14503


val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, -1, 0, 1)

var N = 0
var M = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.also {
        N = it[0]
        M = it[1]
    }
    val (y, x, d) = readLine().split(" ").map { it.toInt() }


    var position = y to x
    var direction = when (d) {
        0 -> 0
        1 -> 3
        2 -> 2
        else -> 1
    }
    var count = 0
    val map = Array(N) { IntArray(M) }

    repeat(N) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            map[row][column] = value
        }
    }

    while (true) {
        if(map[position.first][position.second]==1)break
        if (map[position.first][position.second] == 0) {
            map[position.first][position.second] = 2
            count += 1
        }

        if (dy.zip(dx)
                .any {
                    checkBound(
                        y = position.first + it.first,
                        x = position.second + it.second
                    ) && map[position.first + it.first][position.second + it.second] == 0
                }
        ) {
            direction = (direction + 1) % 4
            if (
                checkBound(
                    y = position.first + dy[direction],
                    x = position.second + dx[direction]
                ) &&
                map[position.first + dy[direction]][position.second + dx[direction]] == 0
            ) {
                position = position.first + dy[direction] to position.second + dx[direction]

            }
        } else {
            if (!checkBound(
                    y = position.first + dy[(direction + 2) % 4],
                    x = position.second + dx[(direction + 2) % 4]
                ) || map[position.first + dy[(direction + 2) % 4]][position.second + dx[(direction + 2) % 4]] == 1
            ) {
                break
            } else {
                position = position.first + dy[(direction + 2) % 4] to position.second + dx[(direction + 2) % 4]
            }
        }
    }
    println(count)
}

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < M && y < N)
}