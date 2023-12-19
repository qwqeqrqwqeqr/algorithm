package baekjoon.problem3052

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val set : MutableSet<Int> = HashSet()

    repeat(10){
        set.add(readLine().toInt()%42)
    }
    println(set.size)
}