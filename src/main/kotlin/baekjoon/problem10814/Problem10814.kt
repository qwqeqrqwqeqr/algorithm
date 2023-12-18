package baekjoon.problem10814

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val nameList = ArrayList<Information>()
    repeat(readLine().toInt()) {
        readLine().split(" ").apply {
            nameList.add(Information(this[0].toInt(), this[1], it))
        }
    }
    nameList.sortedWith(
        compareBy<Information> { it.age }.thenBy { it.count }
    ).forEach {
        println("${it.age} ${it.name}")
    }
}

data class Information(val age: Int, val name: String, val count: Int)