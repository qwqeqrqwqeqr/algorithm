package baekjoon.problem12845

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().split(" ").map { it.toInt() }
    val L = readLine().split(" ").map { it.toInt() }.toList() as ArrayList<Int>
    var sum = 0
    var max = L.sorted().last()
    L.removeAt(L.indexOf(max))
    L.forEach { sum += it+max }
    println(sum)
}

