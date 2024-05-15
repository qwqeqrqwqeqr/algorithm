package baekjoon.problem10988

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine()

    if (input.length % 2 == 0) {
        val a = input.slice(0 until input.length / 2)
        val b = input.slice(input.length / 2 until  input.length).reversed()

        println(if(a==b) 1 else 0)
    } else {
        val a = input.slice(0 until input.length / 2)
        val b = input.slice(input.length / 2 until  input.length).drop(1).reversed()

        println(if(a==b) 1 else 0)
    }

}