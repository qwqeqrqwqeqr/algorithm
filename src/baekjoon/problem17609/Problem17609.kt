package baekjoon.problem17609

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    repeat(input) {
        palindrome(readLine())
    }

}

fun palindrome(string: String) {
    if (string == string.reversed()) {
        println(0)
    } else {
        var start = 0
        var end = string.length - 1
        while (true) {
            if (string[start] != string[end]) {
                break
            }
            start++
            end--
        }
        var dropStartString = string.removeRange(start, start+1)
        var dropEndString = string.removeRange(end, end+1)
        if (dropStartString == dropStartString.reversed()) {
            println(1)
        } else if (dropEndString == dropEndString.reversed()) {
            println(1)
        } else {
            println(2)
        }

    }

}
