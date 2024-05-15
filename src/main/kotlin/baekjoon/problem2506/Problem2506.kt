package baekjoon.problem2506

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() == 1 }
    var sum = 0
    var acc = 1
    for (i in 0 until n) {
        if (!list[i]) {
            acc = 1
        } else {
            sum += acc
            acc+=1
        }
    }
    println(sum)
}