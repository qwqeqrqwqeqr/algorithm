package baekjoon.problem1543

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val target = readLine()
    val source = readLine()
    var count = 0
    var point = 0
    while (point <= target.length - source.length) {
        if (target.slice(point until point + source.length) == source) {
            count += 1
            point += source.length
        } else {
            point += 1
        }
    }
    println(count)
}