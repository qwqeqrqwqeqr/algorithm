package baekjoon.problem1032

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { "" }
    val bufferedWriter = System.out.bufferedWriter()
    repeat(n) {
        array[it] = readLine()
    }
    val target = array[0]

    for (i in target.indices) {
        if (array.none { target[i] != it[i] }) bufferedWriter.append("${target[i]}")
        else bufferedWriter.append("?")

    }
    bufferedWriter.flush()
}