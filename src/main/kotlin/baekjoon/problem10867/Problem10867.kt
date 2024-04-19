package baekjoon.problem10867

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().toInt()
    val set : MutableSet<Int> = mutableSetOf()
    readLine().split(" ").forEach { set.add(it.toInt()) }
    println(set.sorted().joinToString(" "))
}