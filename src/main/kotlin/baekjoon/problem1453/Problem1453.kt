package baekjoon.problem1453

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val visited = BooleanArray(101) { false }
    val n = readLine().toInt()
    val string = readLine().split(" ").map { it.toInt() }
    var count =0
    for (i in 0 until n) {
        if (visited[string[i]]) {
            count+=1
        } else visited[string[i]] = true
    }
    println(count)
}