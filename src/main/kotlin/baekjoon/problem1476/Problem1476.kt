package baekjoon.problem1476

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (e, s, m) = readLine().split(" ").map { it.toInt() }
    var count = 1
    var tempE = 1
    var tempS = 1
    var tempM = 1
    while (true) {
        if (tempE == e && tempS == s && tempM == m) break
        if (tempE == 15) tempE = 1 else tempE += 1
        if (tempS == 28) tempS = 1 else tempS += 1
        if (tempM == 19) tempM = 1 else tempM += 1
        count += 1
    }
    println(count)
}
