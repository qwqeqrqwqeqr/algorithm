package baekjoon.problem1956


private const val INF = 1000000000
var min = INF
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (V, E) = readLine().split(" ").map { it.toInt() }

    var map = Array(V+1) { IntArray(V+1) { INF } }

    repeat(E){
        readLine().split(" ").map { it.toInt() }.apply {
            map[this[0]][this[1]] =this[2]
        }
    }

    for (k in 1..V ) {
        for (a in 1..V ) {   // 출발 노드
            for (b in 1..V ) {   // 도착 노드
                map[a][b] = map[a][b].coerceAtMost(map[a][k] + map[k][b])
            }
        }
    }

    for (i in 1 .. V){
        min = map[i][i].coerceAtMost(min)
    }
    if(min==INF) println(-1) else println(min)
}

