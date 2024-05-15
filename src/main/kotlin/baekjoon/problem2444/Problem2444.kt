package baekjoon.problem2444

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    for (i in 1..n) {
        for (j in i until n) {
            print(" ")
        }
        for (k in 0 until 2 * i - 1) {
            print("*")
        }
        println()
    }
    for (i in 0 until n) {
        for(k in 0 ..  i){
            print(" ")
        }
        for (j in 0 until  2*(n-i-1) -1)
            print("*")
        println()
    }
}