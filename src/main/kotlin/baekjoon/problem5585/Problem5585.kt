package baekjoon.problem5585


val money = arrayOf(500, 100, 50, 10, 5, 1)
fun main() = with(System.`in`.bufferedReader()) {
    var input = 1000- readLine().toInt()
    var count = 0
    money.forEach {
        while (input >= it) {
            input -= it
            count++
        }
    }
    println(count)
}