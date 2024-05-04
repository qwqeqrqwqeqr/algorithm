package baekjoon.problem1551

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    var list = ArrayList<Int>()
    list.addAll(readLine().split(",").map { it.toInt() })

    repeat(k) {
        val temp = ArrayList<Int>()
        for (i in 1 until list.size) {
            temp.add(list[i] - list[i - 1])
        }
        list.clear()
        list.addAll(temp)
    }
    println(list.joinToString(","))
}