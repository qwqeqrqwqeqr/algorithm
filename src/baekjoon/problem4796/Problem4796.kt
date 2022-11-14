package baekjoon.problem4796

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    var campingList = ArrayList<Triple<Int, Int, Int>>()
    inputData(campingList)

    campingList.forEachIndexed { index, triple ->
        println("Case ${index + 1}: ${(triple.third / triple.second).toInt() * triple.first + if (triple.first > triple.third % triple.second) triple.third % triple.second else triple.first}")
    }
}

fun inputData(campingList: ArrayList<Triple<Int, Int, Int>>) {
    while (true) {
        readLine()!!.split(" ").map { it.toInt() }.toList().apply {
            if (this[0] == 0 && this[1] == 0 && this[2] == 0) {
                return
            } else {
                campingList.add(Triple(this[0], this[1], this[2]))

            }

        }
    }
}