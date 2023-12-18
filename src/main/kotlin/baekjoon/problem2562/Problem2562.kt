package baekjoon.problem2562

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arrayList = ArrayList<Pair<Int, Int>>()
    repeat(9) { arrayList.add(Pair(it + 1, readLine().toInt())) }
    println(arrayList.maxBy { it.second }.let { "${it.second}\n${it.first}" })
}