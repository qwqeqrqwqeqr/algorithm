package baekjoon.problem13164

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val height = readLine().split(" ").map { it.toInt() }.reversed()
    val list = arrayListOf<Int>()
    for(i in  0 until  height.size-1){ list.add(height[i]-height[i+1]) }
    list.sortDescending()
    println( list.drop(input[1]-1).sum())
}