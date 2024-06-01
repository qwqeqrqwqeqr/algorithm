package baekjoon.problem7567

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val string = readLine()
    var sum = 10
    for (i in 1 until string.length) {
        sum +=
            if (string[i - 1] != string[i]) 10
            else 5
    }
    println(sum)
}