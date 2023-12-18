package baekjoon.problem1541


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine()
    val minus = input.split('-').toList().map { it.split('+').sumBy { it.toInt() }.toString() }
    var sum =0
    for(i in 1 until minus.size){
        sum += minus[i].toInt()
    }
    println(minus[0].toInt()-sum)
}

