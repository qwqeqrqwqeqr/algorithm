package baekjoon.problem1074

import kotlin.math.pow


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.apply {
        find(this[2],  this[1], 0.0, this[0].toDouble())
    }

}


fun find(x: Int, y: Int, count: Double, n: Double) {
    if (n.toInt() == 0 && x == 0 && y == 0) {
        println(count.toInt())
        return
    }
    if (x < 2.0.pow(n) / 2 && y < 2.0.pow(n) / 2) {
        find(x, y, count, n - 1)
    } else if (x <= 2.0.pow(n) && y < 2.0.pow(n) / 2) {
        find(x - 2.0.pow(n - 1).toInt(), y, count + (4.0.pow(n - 1)), n - 1)
    } else if (x < 2.0.pow(n) / 2 && y <= 2.0.pow(n)) {
        find(x, y - 2.0.pow(n - 1).toInt(), count + (4.0.pow(n - 1)) * 2, n - 1)
    } else {
        find(x - 2.0.pow(n - 1).toInt(), y - 2.0.pow(n - 1).toInt(), count + (4.0.pow(n - 1)) * 3, n - 1)
    }
}
