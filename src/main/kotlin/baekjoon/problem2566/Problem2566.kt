package baekjoon.problem2566

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = Array(9) { IntArray(9) }
    var max = Int.MIN_VALUE
    var position = 0 to 0
    repeat(9) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            array[row][column] = value
            if (value > max) {
                max = value
                position = row+1 to column+1
            }
        }
    }
    println(max)
    println("${position.first} ${position.second}")
}