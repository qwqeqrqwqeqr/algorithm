package baekjoon.problem4659

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val charArray = charArrayOf('a', 'e', 'i', 'o', 'u')
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    while (true) {
        var str = readLine()
        if (str.equals("end")) break
        if (str.check()) {
            bufferedWriter.append("<$str> is acceptable.\n")
        } else {
            bufferedWriter.append("<$str> is not acceptable.\n")
        }
    }
    bufferedWriter.flush()
}

fun String.check(): Boolean {
    if (this.condition1() < 1) {
        return false
    }
    if (!this.condition2()) {
        return false
    }
    if (!this.condition3()) {
        return false
    }
    return true
}


fun String.condition1(): Int {
    var count = 0
    charArray.forEach {
        if (this.contains(it)) {
            count += 1
        }
    }
    return count
}

fun String.condition2(): Boolean {
    var vowelsCount = 0
    var consonantsCount = 0
    this.forEach {
        if (charArray.contains(it)) {
            consonantsCount = 0
            vowelsCount += 1
        } else {
            vowelsCount = 0
            consonantsCount += 1
        }
        if (vowelsCount >= 3 || consonantsCount >= 3) {
            return false
        }
    }
    return true
}

fun String.condition3(): Boolean {
    var pre = '0'
    for (i in this.indices) {
        if (this[i] == 'e' || this[i] == 'o') {
            pre = this[i]
            continue
        }
        if (this[i] == pre) {
            return false
        }
        pre = this[i]
    }
    return true
}