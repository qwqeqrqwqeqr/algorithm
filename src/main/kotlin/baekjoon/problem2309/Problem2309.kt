package baekjoon.problem2309

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = IntArray(9)
    repeat(9) { array[it] = readLine().toInt() }
    array.sort()
    val sum = array.sum()
    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (sum - array[i] - array[j] == 100) {
                println(array.filterIndexed { index, _ -> index != i && index != j }.joinToString("\n"))
                return@with
            }
        }
    }
}
