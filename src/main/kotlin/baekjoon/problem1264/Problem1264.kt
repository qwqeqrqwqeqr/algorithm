package baekjoon.problem1264

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val list = arrayOf('i', 'e', 'o', 'u', 'a','A','E','I','O','U')
    while (true) {
        val string = readLine()
        if (string == "#") break
        println(string.count { list.contains(it) })
    }
}