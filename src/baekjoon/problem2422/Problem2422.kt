package baekjoon.problem2422



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val map = Array(input[0]+1) { BooleanArray(input[0]+1) { false } }
    repeat(input[1]) {
        readLine().split(" ").map { it.toInt() }.also {
            map[it[0]][it[1]] = true
            map[it[1]][it[0]] = true
        }
    }
    println(combination(input[0], map))
}

fun combination(N: Int, map: Array<BooleanArray>):Int {
    var count =0
    for (i in 1..N) {
        for (j in i+1..N) {
            if (map[i][j]) { continue }
            for (k in j+1..N) {
                if (map[i][k]||map[j][k]) { continue }
                count+=1
            }
        }
    }
    return count
}

