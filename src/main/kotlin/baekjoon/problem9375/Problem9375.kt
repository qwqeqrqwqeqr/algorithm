package baekjoon.problem9375


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val depth = readLine().toInt()
        val clothesMap = HashMap<String, Int>()

        repeat(depth) {
            readLine().split(" ").also {
                if (clothesMap.containsKey(it[1]))
                    clothesMap[it[1]] = clothesMap[it[1]]?.let { it + 1 } ?: 0
                else clothesMap[it[1]] = 1
            }
        }
        println(clothesMap.map { it.value }.fold(1) { acc, i -> acc * (i + 1) }.let { it - 1 })
    }
}


