package baekjoon.problem3003

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    println(readLine().split(" ").mapIndexed { index, s ->
        if (index == 0) 1 - s.toInt()
        else if (index == 1) 1 - s.toInt()
        else if (index == 2) 2 - s.toInt()
        else if (index == 3) 2 - s.toInt()
        else if (index == 4) 2 - s.toInt()
        else 8 - s.toInt()
    }.joinToString(" "))

}