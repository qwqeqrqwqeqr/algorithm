package baekjoon.problem4386

import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt


val unf = IntArray(101) { it }


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val starList = ArrayList<Triple<Int, Double, Double>>()
    val edgeList = ArrayList<Triple<Int, Int, Double>>()
    var answer =0.0
    repeat(n) { index ->
        val (x, y) = readLine().split(" ").map { it.toDouble() }
        starList.add(Triple(index, x, y))
    }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            edgeList.add(
                Triple(
                    starList[i].first, starList[j].first,
                    sqrt(
                        (starList[i].second - starList[j].second).pow(2.0) +
                                (starList[i].third - starList[j].third).pow(2.0)
                    )
                )
            )
        }
    }
    edgeList.sortBy { it.third }
    edgeList.forEach {
        if(find(it.first) != find(it.second)){
            union(it.first, it.second)
            answer+=it.third
        }
    }
    println(DecimalFormat("#.##").format(answer))
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