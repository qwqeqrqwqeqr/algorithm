package baekjoon.problem1259

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val text = readLine()
        if (text.toInt() == 0) break
        println(if(text.toString()==text.reversed()) "yes" else "no")
    }
}