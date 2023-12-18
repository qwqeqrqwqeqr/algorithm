package baekjoon.problem11651


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arrayList = ArrayList<Coordinate>()
    repeat(readLine().toInt()){
        readLine().split(" ").map { it.toInt() }.apply {
            arrayList.add(Coordinate(this[0],this[1]))
        }
    }
   arrayList.sortedWith(
        compareBy<Coordinate> {  it.y }.thenBy { it.x }
    ).forEach {
        println("${it.x} ${it.y}")
   }

}

data class Coordinate(val x:Int,val y:Int)