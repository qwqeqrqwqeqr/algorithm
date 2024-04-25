package baekjoon.problem1431

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = ArrayList<String>()
    repeat(n) { list.add(readLine()) }
    println(
        list
            .sortedWith(compareBy<String> { it.length }
                .thenBy { it.filter { it.isDigit() }.sumOf { it.digitToInt() } }
                .thenBy { it }).joinToString("\n")
    )
}