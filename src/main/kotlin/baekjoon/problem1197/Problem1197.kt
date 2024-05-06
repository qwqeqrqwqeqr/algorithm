package baekjoon.problem1197

val unf = IntArray(100_001) { it }

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val edgeList = ArrayList<Triple<Int, Int, Int>>()
    var result =0
    repeat(e) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        edgeList.add(Triple(a, b, c))
    }
    edgeList.sortWith { o1, o2 -> o1.third - o2.third }


    edgeList.forEach {
        if(find(it.first) != find(it.second)){
            union(it.first,it.second)
            result+=it.third
        }
    }
    println(result)
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