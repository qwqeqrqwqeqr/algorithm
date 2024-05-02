package baekjoon.problem2096

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { IntArray(3) }
    repeat(n) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { column, value ->
            array[row][column] = value
        }
    }
    val minDp = array[0].copyOf()
    val maxDp = array[0].copyOf()


    for (i in 1 until  array.size) {
        val tempMinDp = minDp.copyOf()

        minDp[0] = Math.min(tempMinDp[0], tempMinDp[1]) + array[i][0]
        minDp[1] = Math.min(tempMinDp[0], Math.min(tempMinDp[1], tempMinDp[2])) + array[i][1]
        minDp[2] = Math.min(tempMinDp[1], tempMinDp[2]) + array[i][2]

        val tempMaxDp = maxDp.copyOf()

        maxDp[0] = Math.max(tempMaxDp[0], tempMaxDp[1]) + array[i][0]
        maxDp[1] = Math.max(tempMaxDp[0], Math.max(tempMaxDp[1], tempMaxDp[2])) + array[i][1]
        maxDp[2] = Math.max(tempMaxDp[1], tempMaxDp[2]) + array[i][2]
    }
    println("${maxDp.max()} ${minDp.min()}")
}

