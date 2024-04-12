package baekjoon.problem17144


val dy = arrayOf(-1, 0, 1, 0)
val dx = arrayOf(0, 1, 0, -1)

val topAirCleanerDY = arrayOf(-1, 0, 1, 0)
val topAirCleanerDX = arrayOf(0, 1, 0, -1)

val bottomAirCleanerDY = arrayOf(1, 0, -1, 0)
val bottomAirCleanerDX = arrayOf(0, 1, 0, -1)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (r, c, t) = readLine().split(" ").map { it.toInt() }
    var map = Array(r) { IntArray(c) { 0 } }
    var airCleaner: Pair<Coordinate?, Coordinate?> = Pair(null, null)

    repeat(r) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            map[row][column] = value
            if (value == -1) {
                airCleaner = if (airCleaner.first == null) airCleaner.copy(first = Coordinate(row, column))
                else airCleaner.copy(second = Coordinate(row, column))
            }
        }
    }

    repeat(t) {
        map = spread(map, r, c)
        clean(map, airCleaner, r, c)
    }
   println(map.sumOf { it.sum() }+2)

}

fun spread(map: Array<IntArray>, R: Int, C: Int): Array<IntArray> {
    val newMap = Array(R) { IntArray(C) { 0 } }

    map.forEachIndexed { row, array ->
        array.forEachIndexed { column, value ->
            when (val target = map[row][column]) {
                -1 -> newMap[row][column] = -1
                0 -> {}
                else -> {
                    var count = 0
                    for (i in 0..3) {
                        if (checkBound(
                                0,
                                0,
                                R,
                                C,
                                row + dy[i],
                                column + dx[i]
                            ) && map[row + dy[i]][column + dx[i]] != -1
                        ) {
                            newMap[row + dy[i]][column + dx[i]] += target / 5
                            count += 1
                        }
                    }
                    newMap[row][column] += target - ((target / 5) * count)
                }
            }
        }
    }
    return newMap
}

fun clean(map: Array<IntArray>, airCleaner: Pair<Coordinate?, Coordinate?>, R: Int, C: Int) {

    var topAirCleanerStartPoint = airCleaner.first!!
    var bottomAirCleanerStartPoint = airCleaner.second!!
    for (i in 0..3) {
        while (checkBound(
                0, 0, airCleaner.first!!.y + 1, C,
                topAirCleanerStartPoint.y + topAirCleanerDY[i],
                topAirCleanerStartPoint.x + topAirCleanerDX[i]
            )
        ) {
            if (map[topAirCleanerStartPoint.y][topAirCleanerStartPoint.x] != -1) {
                if (map[topAirCleanerStartPoint.y + topAirCleanerDY[i]][topAirCleanerStartPoint.x + topAirCleanerDX[i]] == -1)
                    map[topAirCleanerStartPoint.y][topAirCleanerStartPoint.x] = 0
                else {
                    map[topAirCleanerStartPoint.y][topAirCleanerStartPoint.x] =
                        map[topAirCleanerStartPoint.y + topAirCleanerDY[i]][topAirCleanerStartPoint.x + topAirCleanerDX[i]]
                }
            }
            topAirCleanerStartPoint = Coordinate(
                topAirCleanerStartPoint.y + topAirCleanerDY[i],
                topAirCleanerStartPoint.x + topAirCleanerDX[i]
            )
        }
    }


    for (i in 0..3) {
        while (checkBound(
                airCleaner.second!!.y, 0, R, C,
                bottomAirCleanerStartPoint.y + bottomAirCleanerDY[i],
                bottomAirCleanerStartPoint.x + bottomAirCleanerDX[i]
            )
        ) {
            if (map[bottomAirCleanerStartPoint.y][bottomAirCleanerStartPoint.x] != -1) {
                if (map[bottomAirCleanerStartPoint.y + bottomAirCleanerDY[i]][bottomAirCleanerStartPoint.x + bottomAirCleanerDX[i]] == -1)
                    map[bottomAirCleanerStartPoint.y][bottomAirCleanerStartPoint.x] = 0
                else {
                    map[bottomAirCleanerStartPoint.y][bottomAirCleanerStartPoint.x] =
                        map[bottomAirCleanerStartPoint.y + bottomAirCleanerDY[i]][bottomAirCleanerStartPoint.x + bottomAirCleanerDX[i]]
                }
            }
            bottomAirCleanerStartPoint = Coordinate(
                bottomAirCleanerStartPoint.y + bottomAirCleanerDY[i],
                bottomAirCleanerStartPoint.x + bottomAirCleanerDX[i]
            )
        }
    }
}

fun checkBound(minR: Int, minC: Int, maxR: Int, maxC: Int, y: Int, x: Int): Boolean =
    y in minR until maxR && x in minC until maxC

data class Coordinate(val y: Int, val x: Int)