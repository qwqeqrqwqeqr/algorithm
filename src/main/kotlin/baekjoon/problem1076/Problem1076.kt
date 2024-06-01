package baekjoon.problem1076

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = HashMap<String, Pair<String, Long>>()
    map["black"] = "0" to 1L
    map["brown"] = "1" to 10L
    map["red"] = "2" to 100L
    map["orange"] = "3" to 1_000L
    map["yellow"] = "4" to 10_000L
    map["green"] = "5" to 100_000L
    map["blue"] = "6" to 1_000_000L
    map["violet"] = "7" to 10_000_000L
    map["grey"] = "8" to 100_000_000L
    map["white"] = "9" to 1_000_000_000L
    println(map[readLine()]!!.first.plus(map[readLine()]!!.first).toLong() * map[readLine()]?.second!!.toLong())
}