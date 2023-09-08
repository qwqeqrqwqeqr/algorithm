package baekjoon.problem1018


var min = Int.MAX_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val array = Array(input[0]) { CharArray(input[1]) { '0' } }

    repeat(input[0]) { it ->
        readLine().forEachIndexed { index, c ->
            array[it][index] = c
        }
    }

    cutBoard(array, input[0], input[1])


    println(min)

}

fun cutBoard(array: Array<CharArray>, maxHeight: Int, maxWidth: Int) {
    for (i in 0 until maxHeight - 7) {
        for (j in 0 until maxWidth - 7) {

            array.sliceArray(i until 8 + i).map {
                it.slice(j until 8 + j)
            }.apply {
                findMinFill(this, true)
                findMinFill(this, false)
            }
        }
    }
}


fun findMinFill(array: List<List<Char>>, target: Boolean) {
    var count = 0
    array.forEachIndexed { charsIndex, chars ->
        chars.forEachIndexed { cIndex, c ->
            when (target) {
                true -> {
                    if (cIndex % 2 == 0 && charsIndex % 2 == 0 && c == 'B') {

                    } else if (cIndex % 2 == 1 && charsIndex % 2 == 1 && c == 'B') {

                    } else if (cIndex % 2 == 1 && charsIndex % 2 == 0 && c == 'W') {

                    } else if (cIndex % 2 == 0 && charsIndex % 2 == 1 && c == 'W') {

                    } else {
                        count += 1
                    }
                }

                false -> {
                    if (cIndex % 2 == 0 && charsIndex % 2 == 0 && c == 'W') {

                    } else if (cIndex % 2 == 1 && charsIndex % 2 == 1 && c == 'W') {

                    } else if (cIndex % 2 == 1 && charsIndex % 2 == 0 && c == 'B') {

                    } else if (cIndex % 2 == 0 && charsIndex % 2 == 1 && c == 'B') {

                    } else {
                        count += 1
                    }
                }
            }
        }
    }
    if (min >= count)  min = count
}