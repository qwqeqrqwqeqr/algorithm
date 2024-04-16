package baekjoon.problem4673

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val array = BooleanArray(10_001) { true }

    for (i in 1 until array.size) {
        if (array[i]) {
            var target = i + i.toString().map { it.digitToInt() }.sum()
            while (target < array.size) {
                array[target] = false
                target += target.toString().map { it.digitToInt() }.sum()
            }
        }
    }

    println(array.mapIndexed { index, b -> if (b) index else -1 }
        .filter { it != -1 }
        .drop(1)
        .joinToString("\n")
    )

}