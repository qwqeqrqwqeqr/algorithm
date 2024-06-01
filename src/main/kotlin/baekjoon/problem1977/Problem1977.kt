package baekjoon.problem1977

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val from = readLine().toInt()
    val to = readLine().toInt()
    val booleanArray = BooleanArray(10_001) { false }

    for (i in 1..100) {
        booleanArray[i * i] = true
    }
    booleanArray.mapIndexed { index, b -> index to b }.slice(from..to).filter { it.second }.also {
        if(it.isEmpty()) println(-1)
        else {
            println(it.sumOf { it.first })
            println(it.minOf { it.first })
        }
    }
}