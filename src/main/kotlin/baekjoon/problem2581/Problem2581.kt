package baekjoon.problem2581

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val prime = BooleanArray(10_001) { true }.also {
        it.fill(false, 0, 2)
    }
    val from = readLine().toInt()
    val to = readLine().toInt()

    for (i in 2 until prime.size) {
        if (prime[i]) {
            var count = i
            while (count * i < 10_001) {
                prime[i * count++] = false
            }
        }
    }
        prime.mapIndexed { index, b -> index to b }.slice(from .. to).filter { it.second }.also {
            if(it.isEmpty()){
                println(-1)
            }else {
                println(it.sumOf { it.first })
                println(it.minOf { it.first })
            }
        }
}