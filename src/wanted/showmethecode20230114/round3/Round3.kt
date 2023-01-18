package wanted.showmethecode20230114.round3


import kotlin.math.max

var max = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val input = readLine().split(" ").map { it.toInt() }
    val map = Array( max(input[0],input[1])+1) { IntArray( max(input[0],input[1])+1){0} }
    repeat(input[2]){
        readLine().split(" ").map { it.toInt() }.toList().forEachIndexed { index, i ->
            map[it+1][index+1] =i
        }
    }
    val a = readLine().split(" ").map { it.toInt() }.toMutableList()
    val b = readLine().split(" ").map { it.toInt() }.toMutableList().reversed()
    val queue = ArrayList<Int>()
    repeat(a.size){ queue.add(0) }

    repeat(b.size){
        queue.removeLast()
        queue.add(0,b[it])
        var tempMax =0
        for(i in a.indices){
            tempMax+=map[a[i]][queue[i]]
        }
        max= max(tempMax, max)
    }
    repeat(b.size){
        queue.removeLast()
        queue.add(0,0)
        var tempMax =0
        for(i in a.indices){
            tempMax+=map[a[i]][queue[i]]
        }
        max= max(tempMax, max)
    }
    println(max)

}