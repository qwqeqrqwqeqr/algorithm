package baekjoon.problem2490

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(3) {
        val list = readLine().split(" ").map { it.toInt() }
        println(if (list.count { it == 1 } == 4) {
            "E"
        } else if (list.count { it == 0 } == 4) {
            "D"
        } else if (list.count { it == 0 } == 3) {
            "C"
        } else if (list.count { it == 0 } == 2) {
            "B"
        } else "A")
    }
}