package baekjoon.problem10101

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val array = IntArray(3)
    repeat(3) {
        array[it] = readLine().toInt()
    }
    println(
        if (array.none { it != 60 }) "Equilateral"
        else if (array.sum() == 180 && array.toSet().size <= 2) "Isosceles"
        else if(array.sum() == 180 && array.toSet().size==3) "Scalene"
        else "Error"
    )
}