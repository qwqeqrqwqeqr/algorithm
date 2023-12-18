package baekjoon.problem20437

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        var game1 = Int.MAX_VALUE; var game2 = Int.MIN_VALUE
        val target = readLine()
        val K = readLine().toInt()
        target.groupBy { it }.filter { it.value.size >= K }.forEach { key ->
            target.withIndex().filter { it.value == key.key }.also { list ->
                for (i in 0 until list.size - K + 1) {
                    val temp = list[i + K - 1].index - list[i].index + 1
                    game1 = Math.min(temp, game1)
                    game2 = Math.max(temp, game2)
                }
            }
        }
        if (game1 == Int.MAX_VALUE || game2 == Int.MIN_VALUE) bufferedWriter.append("-1\n") else bufferedWriter.append(
            "$game1 $game2\n"
        )
    }
    bufferedWriter.flush()
}
