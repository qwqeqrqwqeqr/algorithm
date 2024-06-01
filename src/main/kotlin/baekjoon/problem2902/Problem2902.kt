package baekjoon.problem2902

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferWriter = System.out.bufferedWriter()
    readLine().forEach {
        if (it in 'A'..'Z') bufferWriter.append(it)
    }
    bufferWriter.flush()
}