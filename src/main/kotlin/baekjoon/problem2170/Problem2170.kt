package baekjoon.problem2170

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arrayList = ArrayList<Pair<Long, Long>>()
    repeat(readLine().toInt()) {
        readLine().split(" ").also {
            arrayList.add(it[0].toLong() to it[1].toLong())
        }
    }.also {
        arrayList.sortWith(compareBy({ it.first }, { it.second }))
    }
    var start = Long.MIN_VALUE
    var end = Long.MIN_VALUE
    var total = 0L

    for (i in arrayList.indices) {
        val (x, y) = arrayList[i]
        if (end < x) {
            total += end - start
            start = x
            end = y
        } else {
            end = y.coerceAtLeast(end)
        }
    }
    println(total+(end-start))
}



