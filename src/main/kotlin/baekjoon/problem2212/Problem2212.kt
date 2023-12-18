package baekjoon.problem2212

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val K = readLine().toInt()
    val sensor =readLine().split(" ").map { it.toInt() }.sorted()
    val distance = ArrayList<Int>()
    for(i in 1 until  sensor.size){
        distance.add(sensor[i]-sensor[i-1])
    }
    println(distance.sortedDescending().drop(K-1).sum())
}