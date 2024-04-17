package baekjoon.problem7785

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = HashMap<String, Unit>()
    repeat(readLine().toInt()) {
        val (a, b) = readLine().split(" ")

        if (map.containsKey(a)) {
            map.remove(a)
        } else map[a] = Unit
    }
    println(map.keys.sortedDescending().joinToString("\n"))
}