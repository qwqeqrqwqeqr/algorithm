package baekjoon.problem1292

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(1001)

    var i = 1
    var number = 1
    var count = 0
    while (i < array.size) {
        if (number == count) {
            number++
            count = 0
        }
        array[i] = number
        count += 1
        i += 1
    }
    println(array.slice(a..b).sum())
}
