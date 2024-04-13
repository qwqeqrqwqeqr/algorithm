package baekjoon.problem13305

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val road = LongArray(n - 1) { 0 }
    val city = LongArray(n) { 0 }

    readLine().split(" ").map { it.toLong() }.forEachIndexed { index, i -> road[index] = i }
    readLine().split(" ").map { it.toLong() }.forEachIndexed { index, i -> city[index] = i }

    var result = 0L
    var min = Long.MAX_VALUE

    for (i in road.indices) {
        min = Math.min(min, city[i])
        result += min * road[i]
    }
    println(result)
}


