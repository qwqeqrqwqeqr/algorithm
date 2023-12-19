package baekjoon.problem11050

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.run {
        print(binomialCoefficient(this[0]) / (binomialCoefficient(this[1]) * binomialCoefficient(this[0] - this[1])))
    }
}

fun binomialCoefficient(x: Int): Int {
    var r = 1;
    for (i in x downTo 1) r *= i
    return r
}