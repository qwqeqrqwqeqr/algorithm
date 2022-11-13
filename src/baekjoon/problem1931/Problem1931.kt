package baekjoon.problem1931


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val rentalList = ArrayList<Pair<Int, Int>>()
    var answer = 0
    var end = 0

    repeat(input[0]) {
        val temp = readLine().split(" ").map { it.toInt() }
        rentalList.add(Pair(temp[0], temp[1]))
    }
    rentalList.sortWith(compareBy({ it.second }, { it.first }))

    while (true) {
        rentalList.asSequence().filter { pair -> pair.first >= end }.firstOrNull().also {
            if(it==null){ println(answer);return@with }
            answer += 1
            end = it.second
            rentalList.removeAt(0)
        }

    }
}