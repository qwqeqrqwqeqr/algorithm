package baekjoon.problem2805


var result = Long.MIN_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toLong() }.let { it[0] to it[1] }
    val treeList: List<Long> = readLine().split(" ").map { it.toLong() }

    binarySearch(0, treeList.max(), treeList, input.second)

    println(result)
}


fun binarySearch(min: Long, max: Long, treeList: List<Long>, target: Long) {

    if (min > max) return

    val mid = (min + max) / 2
    val calcResult = treeList.map { it - mid }.filter { it > 0 }.sum()

    if(calcResult >= target) {
        result = Math.max(result, mid)
    }

    if (calcResult == target) return
    else if (calcResult < target) binarySearch(min, mid - 1, treeList, target)
    else binarySearch(mid + 1, max, treeList, target)
}

