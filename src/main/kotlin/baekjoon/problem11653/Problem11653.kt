package baekjoon.problem11653

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferWriter = System.out.bufferedWriter()
    val n = readLine().toInt()
    var temp = n

    for (i in 2..n) {
        if (temp <= 1) break
        while (temp % i == 0) {
            temp /= i
            bufferWriter.append("$i\n")
        }
    }
    bufferWriter.flush()
}