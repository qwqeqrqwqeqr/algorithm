package baekjoon.problem5597

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val visited = BooleanArray(31) { false }
    repeat(28) {
        visited[readLine().toInt()] = true
    }
    for(i in 1 until 31){
        if(!visited[i]) println(i)
    }
}