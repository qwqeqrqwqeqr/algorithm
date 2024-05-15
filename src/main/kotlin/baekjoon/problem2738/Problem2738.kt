package baekjoon.problem2738

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(m) }
    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            array[row][column] = value
        }
    }
    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            array[row][column] += value
        }
    }
    array.forEach {
        println(it.joinToString(" "))
    }

}