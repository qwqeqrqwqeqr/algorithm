package baekjoon.problem18870


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine()
    val list = readLine().split(" ").map { it.toInt() }
    val map: HashMap<Int, Int> = HashMap()
    list.sorted().distinct().forEachIndexed { index, i -> map[i] = index }
    println(list.map { map[it] }.joinToString(" "))
}


