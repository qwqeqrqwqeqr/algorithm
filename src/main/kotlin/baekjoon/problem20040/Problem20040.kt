package baekjoon.problem20040

val unf = IntArray(500_001) { it }

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var time = 0
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        if (find(a) != find(b)) {
            union(a, b)
        } else {
            if (time == 0) time = it + 1
        }
    }
    println(time)
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