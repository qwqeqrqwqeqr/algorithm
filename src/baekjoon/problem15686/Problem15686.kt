package baekjoon.problem15686

import kotlin.math.abs

var min = 999999
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map: ArrayList<java.util.ArrayList<Int>> = arrayListOf(arrayListOf())
    val chickenHouse = ArrayList<Pair<Int, Int>>()
    val house = ArrayList<Pair<Int, Int>>()
    val input = readLine().split(" ").map { it.toInt() }
    for( i in 0 until  input[0]) {
        map.add(readLine().split(" ").map { it.toInt() }.toList().also {
            it.forEachIndexed { index, j ->
                when (j) {
                    1 -> house.add(Pair(i, index))
                    2 -> chickenHouse.add(Pair(i, index))
                }
            }
        } as java.util.ArrayList<Int>)
    }
    dfs(house, chickenHouse, input[1])

    println(min)
}

fun dfs(house: ArrayList<Pair<Int, Int>>, chickenHouse: ArrayList<Pair<Int, Int>>, M: Int) {
    if (chickenHouse.size == M) {
        min = Math.min(getMinDistanceTotal(house, chickenHouse), min)
        return
    } else {
        for(i in 0 until  chickenHouse.size){
            val temp : ArrayList<Pair<Int, Int>>  = chickenHouse.clone() as ArrayList<Pair<Int, Int>>
            temp.removeAt(i)
            dfs(house,temp,M)
        }
    }
}

//visited[] =
//i+1

fun getMinDistanceTotal(house: ArrayList<Pair<Int, Int>>, chickenHouse: ArrayList<Pair<Int, Int>>): Int {
    var minDistanceTotal = 0
    house.forEach { h ->
        var minDistance = 100000
        chickenHouse.forEach { c ->
            minDistance = Math.min(minDistance, abs(h.first - c.first) + abs((h.second - c.second)))
        }
        minDistanceTotal += minDistance
    }
    return minDistanceTotal
}