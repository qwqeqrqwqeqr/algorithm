package baekjoon.problem9342

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
val array = charArrayOf('A', 'B', 'C', 'D', 'E', 'F')
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        if (readLine().check()) bufferedWriter.append("Good\n") else bufferedWriter.append("Infected!\n")
    }
    bufferedWriter.flush()

}


fun String.check(): Boolean {
    val regex = Regex("[A-F]?A+F+C+[A-F]?$")
    return !regex.matches(this)
}
