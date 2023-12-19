package baekjoon.problem2920

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val origin = readLine().split(" ").map { it.toInt() }
    println(
        if (origin.toString() == origin.sorted().toString()) {
            "ascending"
        } else if (origin.toString() == origin.sortedDescending().toString()) {
            "descending"
        } else
            "mixed"
    )
}