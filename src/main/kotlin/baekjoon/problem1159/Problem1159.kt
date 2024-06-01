package baekjoon.problem1159

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = HashMap<Char, Int>()
    repeat(n) {
        val value = readLine()[0]
        map[value] = map.getOrDefault(value, 0) + 1
    }
    println(map.filter { it.value >= 5 }.map { it.key }.sorted().let {
        if (it.isEmpty()) "PREDAJA"
        else it.joinToString("")
    })
}