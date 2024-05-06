package baekjoon.problem2887

import kotlin.math.abs


val unf = IntArray(100_001) { it }


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val planetList = ArrayList<Planet>()
    val edgeList = ArrayList<Triple<Int, Int, Int>>()
    var answer =0
    repeat(n) {
        readLine().split(" ").map { it.toInt() }.also { planet ->
            planetList.add(Planet(it, planet[0], planet[1], planet[2]))
        }
    }
    planetList.sortBy { it.x }
    for (i in 1 until planetList.size) {
            edgeList.add(Triple(planetList[i].id, planetList[i-1].id, abs(planetList[i].x - planetList[i-1].x)))
    }
    planetList.sortBy { it.y }
    for (i in 1 until planetList.size) {
            edgeList.add(Triple(planetList[i].id, planetList[i-1].id, abs(planetList[i].y - planetList[i-1].y)))
    }
    planetList.sortBy { it.z }
    for (i in 1 until planetList.size) {
            edgeList.add(Triple(planetList[i].id, planetList[i-1].id, abs(planetList[i].z - planetList[i-1].z)))
    }
    edgeList.sortedBy { it.third }.forEach {
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

data class Planet(
    val id: Int,
    val x: Int,
    val y: Int,
    val z: Int
)