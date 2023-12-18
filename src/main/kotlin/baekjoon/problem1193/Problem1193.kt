package baekjoon.problem1193


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var index = readLine().toInt()
    var step = 0

    for (i in 1..Int.MAX_VALUE) {
        if (i >= index) {
            step = i
            break
        }
        index -= i
    }

    when (step % 2) {
        0 -> {
            println("${index}/${step +1 - index}")
        }
        1 -> {
            println("${step +1 - index}/${index}")
        }
    }
}


