package baekjoon.problem6550

import java.io.*

fun main() {
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    val bufferReader = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val string: String = bufferReader.readLine() ?: break
        if (string.isEmpty()) break
        string.split(" ").also {
            if (check(it[0], it[1])) bufferedWriter.append("Yes\n") else bufferedWriter.append("No\n")
        }
    }
    bufferedWriter.flush()
}


fun check(source: String, target: String): Boolean {
    target.filter { source.contains(it) }.also {
        var count = 0
        it.forEachIndexed { index, c ->
            if (c == source[count]) count++
            if (count == source.length) {
                return true
            }
        }
    }
    return false
}

