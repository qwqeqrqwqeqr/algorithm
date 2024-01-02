package baekjoon.problem1389


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val array = Array(N + 1) { IntArray(N + 1) { 5001 } }.apply { repeat(size){ this[it][it] =0} }
    repeat(M) {
        readLine().split(" ").map { it.toInt() }.apply {
            array[get(0)][get(1)] = 1
            array[get(1)][get(0)] = 1
        }
    }
    for (k in 1..N) {
        for (a in 1..N) {   // 출발 노드
            for (b in 1..N) {   // 도착 노드
                array[a][b] = array[a][b].coerceAtMost((array[a][k] + array[k][b]))
            }
        }
    }
   println(array.drop(1).mapIndexed { index,it -> Pair(index,it.drop(1).sum()) }.minBy { it.second }.first+1)

}

