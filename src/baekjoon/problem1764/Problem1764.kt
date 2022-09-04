package baekjoon.problem1764

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(' ').map { it.toInt() }
    val N = input[0]
    val M = input[1]
    var nSet: HashSet<String> = HashSet()
    var mSet: HashSet<String> = HashSet()
    repeat(N) {  nSet.add(readLine())  }
    repeat(M) {  mSet.add(readLine())  }

    val answer = nSet.intersect(mSet).sorted()
    println(answer.size)
    answer.forEach {
        println(it)
    }

}