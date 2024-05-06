package baekjoon.problem12738

val lis = ArrayList<Int>()

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = readLine().split(" ").map { it.toInt() }
    lis.add(array[0])
    for (i in 1 until n) {
        if (lis[lis.size - 1] < array[i]) lis.add(array[i])
        else lis[lis.binarySearch(array[i])] = array[i]
    }
    println(lis.size)
}


fun List<Int>.binarySearch(element: Int): Int {
    var low = 0
    var high = this.size - 1
    while (low < high) {
        val mid = (low + high) / 2
        val midVal = this[mid]
        if (midVal >= element) high = mid
        else low = mid + 1
    }
    return high
}
