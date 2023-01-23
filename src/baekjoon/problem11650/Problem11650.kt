package baekjoon.problem11650

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arrayList = ArrayList<Coordinate>()
    repeat(readLine().toInt()){
        readLine().split(" ").map { it.toInt() }.apply {
            arrayList.add(Coordinate(this[0],this[1]))
        }
    }
    arrayList.sortedWith(
        compareBy<Coordinate> {  it.x }.thenBy { it.y }
    ).forEach {
        println("${it.x} ${it.y}")
    }

}

data class Coordinate(val x:Int,val y:Int)