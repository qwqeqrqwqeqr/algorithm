package baekjoon.problem11404

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val city = readLine().toInt()
    val bus = readLine().toInt()

    val graph = Array(city + 1) { IntArray(city + 1) { Int.MAX_VALUE / 2 } }

    repeat(bus) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }

        graph[a][b] = Math.min(c, graph[a][b])
    }


    for (k in 1..city) {
        for (a in 1..city) {
            for (b in 1..city) {
                graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b])
            }
        }
    }
    graph.drop(1).forEachIndexed { index, array ->
        array[index + 1] = 0
        println(array.drop(1).map { if (Int.MAX_VALUE / 2 == it) 0 else it }.joinToString(" "))
    }
}