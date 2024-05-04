package baekjoon.problem11557

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val map = HashMap<String, Int>()
        repeat(readLine().toInt()) {
            val (s, l) = readLine().split(" ")
            map[s] = map.getOrDefault(s, 0) + l.toInt()
        }
        println(map.maxBy { it.value }.key)
    }
}