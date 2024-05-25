package baekjoon.problem11504

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val increaseArray = readLine().split(" ").map { it.toInt() }
    val decreaseArray = increaseArray.reversed()
    val lis = IntArray(n) { 1 }
    val lds = IntArray(n) { 1 }


    for (i in 0 until n) {
        for (j in 0 until i) {
            if (increaseArray[i] > increaseArray[j]) {
                lis[i] = Math.max(lis[j] + 1, lis[i])
            }
            if (decreaseArray[i] > decreaseArray[j]){
                lds[i] = Math.max(lds[i], lds[j] + 1)
            }
        }
    }
    println(lis.toList().zip(lds.reversed()).maxOf { it.first+it.second }-1)

}