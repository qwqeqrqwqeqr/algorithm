package baekjoon.problem1976


val unf = IntArray(201) { it }
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()

    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, i ->
            if (i == 1) union(row + 1, column + 1)
        }
    }

    val plan = readLine().split(" ").map { find(it.toInt()) }

    println(if (plan.toSet().size > 1) "NO" else "YES")
}


fun find(v: Int): Int {
    return if (v == unf[v]) return v
    else find(unf[v])
}

fun union(v: Int, w: Int) {
    val a = find(v)
    val b = find(w)
    if (a < b) unf[b] = a
    else unf[a] = b
}




