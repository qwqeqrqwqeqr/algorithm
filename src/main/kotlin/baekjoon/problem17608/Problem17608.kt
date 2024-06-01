package baekjoon.problem17608

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(n)
    repeat(n) {
        array[it] = readLine().toInt()
    }
    array.reverse()
    var position = array[0]
    var count = 1

    for (i in 1 until array.size) {
        if (array[i] > position) {
            ++count
            position = array[i]
        }
    }
    println(count)
}