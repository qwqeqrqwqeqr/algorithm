package baekjoon.problem15686

import kotlin.math.abs

val chickenList = ArrayList<Pair<Int, Int>>()
val houseSet = HashSet<Pair<Int, Int>>()
val visited = BooleanArray(13) { false }
var min = Int.MAX_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            when (value) {
                1 -> houseSet.add(row to column)
                2 -> chickenList.add(row to column)
                else -> {}
            }
        }
    }

    dfs(visited, m, 0, 0)
    println(min)
}


fun dfs(visited: BooleanArray, m: Int, start: Int, depth: Int) {
    if (depth == m) {
        val filteredList = chickenList.filterIndexed { index, _ -> visited[index] }
        min = houseSet.sumOf { house ->
            filteredList.minOf { abs(it.first - house.first) + abs(it.second - house.second) }
        }.coerceAtMost(min)
        return
    }
    for (i in start until chickenList.size) {
        if (!visited[i]) {
            visited[i] = true
            dfs(visited, m, i+1,depth + 1)
            visited[i] = false
        }
    }
}

