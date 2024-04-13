package baekjoon.problem1789

fun main() = with(System.`in`.bufferedReader()) {

    val input = readLine().toLong()
    var count = 0L
    var target = 0L
    for (i in 1..input) {
        if (target > input) break
        target += i
        count += 1
    }

    println(if (target == input) count else count - 1)
}
