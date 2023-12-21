package baekjoon.problem18111


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, M, B) = readLine().split(" ").map { it.toInt() }
    val array = Array(N + 1) { IntArray(M + 1) { -1 } }
    var time = Int.MAX_VALUE
    var height = 0
    repeat(N) {
        readLine().split(" ").mapIndexed { index, s ->
            array[it + 1][index + 1] = s.toInt()
        }
    }
    for (h in 0..256) {
        var inventory = B
        var tempTime = 0
        for (i in 1..N) {
            for (j in 1..M) {
                if (array[i][j] < h) {
                    with(h - array[i][j]) {
                        inventory -= this
                        tempTime += this
                    }

                } else if (array[i][j] > h) {
                    with(array[i][j] - h) {
                        inventory += this
                        tempTime += (2 * this)
                    }
                }
            }
        }
        if (inventory >= 0) {
            if (tempTime < time) {
                time = tempTime
                height = h
            }
            if (tempTime == time) {
                height = height.coerceAtLeast(h)
            }
        }
    }
    println("$time $height")
}