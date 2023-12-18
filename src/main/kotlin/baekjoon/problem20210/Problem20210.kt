package baekjoon.problem20210

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val regex = Regex("[0-9]+")
    repeat(readLine().toInt()){
        val temp =readLine()
        temp.split(regex).also { println(it) }
        println(regex.find(temp)?.value)
    }
}