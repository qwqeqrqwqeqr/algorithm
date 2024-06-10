package baekjoon.problem25192

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val set = HashSet<String>()
    var count = 0
    repeat(readLine().toInt()) {
        val text = readLine()
        if (text == "ENTER") set.clear()
        else if (!set.contains(text)) {
            count++
            set.add(text)
        }
    }
    println(count)
}