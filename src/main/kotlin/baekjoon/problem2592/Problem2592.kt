package baekjoon.problem2592

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array =IntArray(10)
    repeat(10){
        array[it] = readLine().toInt()
    }
    println(array.average().toInt())
    println(array.groupBy { it }.maxBy { it.value.size }.key)
}