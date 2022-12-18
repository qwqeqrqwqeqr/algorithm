package baekjoon.problem2437

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val weight = readLine().split(" ").map { it.toInt() }.sorted()

    var sum =0
        for (i in weight.indices){
            if(sum+1 < weight[i]){ break }
            sum += weight[i]
        }

    println(sum+1)
}