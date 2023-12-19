package baekjoon.problem10809

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val text = readLine()
    println(('a'..'z').map {
        var temp = -1
        run {
            text.forEachIndexed { index, c ->
                if (it == c) {
                    temp = index
                    return@run
                }
            }
        }
        temp
    }.joinToString(" "))
}