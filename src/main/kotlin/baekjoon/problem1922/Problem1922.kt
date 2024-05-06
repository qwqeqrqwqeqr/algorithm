package baekjoon.problem1922

val unf = IntArray(1001) { it }


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val edgeList = ArrayList<Triple<Int, Int, Int>>()
    var answer =0
    repeat(m) {
        readLine().split(" ").map { it.toInt() }.also {
            edgeList.add(Triple(it[0], it[1], it[2]))
        }
    }
    edgeList.sortBy { it.third }
    edgeList.forEach {
        if(find(it.first)!= find(it.second)){
            union(it.first,it.second)
            answer+=it.third
        }
    }
    println(answer)
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