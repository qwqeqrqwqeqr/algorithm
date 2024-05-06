package baekjoon.problem10775


val unf = IntArray(100_001) { it }


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val g = readLine().toInt()
    val p = readLine().toInt()
    var result = 0
    for (i in 0 until p) {
        val item = find(readLine().toInt())
        if (item == 0) break
        union(item, item - 1)
        result += 1
    }
    println(result)
}


fun find(v: Int): Int {
    return if (v == unf[v]) v
    else {
        unf[v] = find(unf[v])
        unf[v]
    }
}


fun union(v: Int, w: Int) {
    val a = find(v)
    val b = find(w)
    if (a < b) unf[b] = a
    else unf[a] = b
}