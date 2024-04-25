package baekjoon.problem2960

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    var count = 1
    var answer = 0
    val array = BooleanArray(n + 1) { false }

    for (i in 2..n) {
        var temp = i
        while (temp <= n) {
            if (!array[temp]) {
                array[temp] = true
                if (count == k) answer = temp
                count += 1
            }
            temp += i
        }
    }
    println(answer)
}