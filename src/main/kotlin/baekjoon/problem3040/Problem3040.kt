package baekjoon.problem3040

var array = Array(9) { 0 to false }

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(9) {
        array[it] = readLine().toInt() to false
    }
    dfs(0,0)
}

fun dfs(start: Int, depth: Int) {
    if (depth == 2) {
        array.filter { !it.second }.map { it.first }.also {
            if (it.sum() == 100) println(it.joinToString("\n"))
        }
        return
    } else {
        for (i in start until array.size) {
            array[i] = array[i].copy(second = true)
            dfs(i+1, depth + 1)
            array[i] = array[i].copy(second = false)
        }
    }
}