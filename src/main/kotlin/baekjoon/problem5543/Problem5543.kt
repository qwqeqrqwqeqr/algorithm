package baekjoon.problem5543

fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val foods = ArrayList<Int>()
    val drinks = ArrayList<Int>()
    repeat(3){
        foods.add(readLine().toInt())
    }
    repeat(2){
        drinks.add(readLine().toInt())
    }
    println(foods.min()+drinks.min()-50)
}