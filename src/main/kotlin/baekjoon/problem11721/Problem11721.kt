package baekjoon.problem11721

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferWriter = System.out.bufferedWriter()
    var input = readLine()

    while (input.isNotEmpty()) {
        if (input.length <= 10) {
            bufferWriter.append("${input}\n")
            input = ""
        } else {
            bufferWriter.append("${input.slice(0 until 10)}\n")
            input = input.drop(10)
        }
    }
    bufferWriter.flush()
}