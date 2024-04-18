package baekjoon.problem1065


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var count = 0
    for (i in 1..N) {
        if (i.toString().calc()) count++
    }
    println(count)

}


fun String.calc(): Boolean {
    if (length < 3) return true
    val diff =  this[1] -this[0]
    for (i in 2 until this.length) {
        if (this[i] - this[i - 1] != diff) return false
    }
    return true
}

