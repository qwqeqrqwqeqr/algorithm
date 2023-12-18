package baekjoon.problem1157


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val list = readLine().map { it.uppercase() }.groupBy { it }.map { it.value }
    val maxValue = list.maxBy { it.size }.size
    println(list.filter { it.size == maxValue }.let { if(it.count()>1) "?" else it.first().first() }  )
}