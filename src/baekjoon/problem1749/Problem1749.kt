package baekjoon.problem1749

var max = Int.MIN_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val map = Array(N + 1) { IntArray(M + 1) { 0 } }


    repeat(N) {
        val list = readLine().split(" ").map { it.toInt() }
        for (i in 1..M) {
            map[it + 1][i] = map[it][i] + map[it + 1][i - 1] + list[i - 1] - map[it][i - 1]
        }
    }
    for (x2 in 1 .. N){
        for (y2 in 1 .. M){
            for (x1 in 1 .. x2){
                for (y1 in 1 .. y2){
                    max = max.coerceAtLeast(map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1])
                }
            }
        }
    }

    println(max)
}