package baekjoon.problem1647


val unf = IntArray(100_001) { it }

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val edgeList = ArrayList<Triple<Int, Int, Int>>()
    var answer = 0
    var max = Int.MIN_VALUE
    repeat(m) {
        readLine().split(" ").map { it.toInt() }.also {
            edgeList.add(Triple(it[0], it[1], it[2]))
        }
    }
    edgeList.sortBy { it.third }
    edgeList.forEach {
        if (find(it.first) != find(it.second)) {
            union(it.first, it.second)
            answer += it.third
            max = Math.max(it.third, max)
        }
    }
    println(answer-max)
}

fun find(v: Int): Int {
    return if (v == unf[v]) v
    else find(unf[v])
}

fun union(v: Int, w: Int) {
    val a = find(v)
    val b = find(w)
    if (a < b) unf[b] = a
    else unf[a] = b
}


