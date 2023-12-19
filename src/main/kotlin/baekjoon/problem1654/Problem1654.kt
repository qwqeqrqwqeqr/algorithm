package baekjoon.problem1654


var maxValue = Long.MIN_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (K, N) = readLine().split(" ").map { it.toInt() }
    val array = LongArray(K) { -1 }
    repeat(K) { array[it] = readLine().toLong() }
    binarySearch(1, Int.MAX_VALUE.toLong()+1, N.toLong(), array)
    println(maxValue)
}

fun binarySearch(min: Long, max: Long, target: Long, array: LongArray) {
    if (min > max) return
    val mid = (min + max) / 2
    array.sumOf { it / mid }.run {
        if (this >= target) {
            maxValue = maxValue.coerceAtLeast(mid)
        }

        if (this >= target) {
            binarySearch(mid + 1, max, target, array)
        } else {
            binarySearch(min, mid - 1, target, array)
        }
    }
}

