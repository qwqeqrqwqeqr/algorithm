package baekjoon.problem8958

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val bufferedWriter = System.out.bufferedWriter()
    repeat(readLine().toInt()) {
        var total = 0
        var acc = 1

        readLine().forEach {
            when (it) {
                'O' -> {
                    total += acc
                    acc += 1
                }

                'X' -> acc = 1
            }
        }
        bufferedWriter.append("${total}\n")
    }
    bufferedWriter.flush()
}