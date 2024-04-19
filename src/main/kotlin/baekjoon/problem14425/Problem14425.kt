package baekjoon.problem14425

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, Unit>()
    var count = 0
    repeat(n) {
        map[readLine()] = Unit
    }
    repeat(m) {
        if (map.containsKey(readLine())) count += 1
    }
    println(count)
}