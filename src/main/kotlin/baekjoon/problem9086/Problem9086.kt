package baekjoon.problem9086


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        readLine().apply {
            println("${first()}${last()}")
        }
    }
}



