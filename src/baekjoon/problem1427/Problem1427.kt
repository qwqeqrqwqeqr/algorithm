package baekjoon.problem1427

fun main() = with(System.`in`.bufferedReader()) {
    println(readLine().map { Character.getNumericValue(it) }.sortedDescending().joinToString(""))
}