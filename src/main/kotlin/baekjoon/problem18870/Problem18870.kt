package baekjoon.problem18870

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine()
    var arrayList = arrayListOf<Coordinate>()
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
        arrayList.add(Coordinate(i, index, 0))
    }
    val tempList = arrayList.sortedBy { it.coordinate }

    var temp = tempList[0].coordinate
    var count = 0
    for(i in tempList.indices){
        if(temp!=tempList[i].coordinate){
            count++
        }
        tempList[i].rank = count
        temp = tempList[i].coordinate
    }

    tempList.sortedBy { it.number }.forEach { print("${it.rank} ") }


}

data class Coordinate(val coordinate: Int, val number: Int, var rank: Int)