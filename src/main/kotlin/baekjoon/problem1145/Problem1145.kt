package baekjoon.problem1145

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = IntArray(5)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> array[index] = i }

    for (i in 1 until 1000001) {
       if(array.count { i % it == 0 }>=3){
           print(i)
           break
       }
    }
}