package baekjoon.problem1547

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = IntArray(3) { it + 1 }
    repeat(n){
        val (a,b) = readLine().split(" ").map { it.toInt()-1 }
        array[a]  = array[b].also { array[b] = array[a] }
    }
    for(i in array.indices){
        if(array[i]==1) println(i+1)
    }
}


