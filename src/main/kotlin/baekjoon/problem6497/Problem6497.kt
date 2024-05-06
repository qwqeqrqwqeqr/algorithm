package baekjoon.problem6497


var unf = IntArray(200_000) { it }

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = System.out.bufferedWriter()
    while (true) {
        val (m, n) = readLine().split(" ").map { it.toInt() }
        val edgeList = ArrayList<Triple<Int, Int, Int>>()
        var answer =0
        if (m == 0 && n == 0) break
        repeat(n) {
            readLine().split(" ").map { it.toInt() }.also {
                edgeList.add(Triple(it[0], it[1], it[2]))
            }
        }
        edgeList.sortedBy { it.third }.forEach {
            if(find(it.first)!=find(it.second)){
                union(it.first,it.second)
                answer+=it.third
            }
        }

        bufferedWriter.append("${edgeList.sumOf { it.third } - answer}\n")
        unf = IntArray(200_001) { it }
    }
    bufferedWriter.flush()
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