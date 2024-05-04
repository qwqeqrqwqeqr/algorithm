package baekjoon.problem2693

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = System.out.bufferedWriter()
    repeat(readLine().toInt()) {
        bufferedWriter.append("${readLine().split(" ").map { it.toInt() }.sortedDescending()[2]}\n")
    }
    bufferedWriter.flush()
}