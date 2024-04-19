package baekjoon.problem10825

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arrayList = ArrayList<Subject>()
    repeat(n) {
        val (a, b, c, d) = readLine().split(" ")
        arrayList.add(Subject(a, b.toInt(), c.toInt(), d.toInt()))
    }
    arrayList.sortWith(comparator = compareByDescending<Subject> { it.korean }.thenBy { it.english }
        .thenByDescending { it.math }.thenBy { it.name })
    println(arrayList.joinToString("\n") { it.name })
}


data class Subject(
    val name: String,
    val korean: Int,
    val english: Int,
    val math: Int
)