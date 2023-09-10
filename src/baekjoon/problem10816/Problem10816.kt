package baekjoon.problem10816




fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val map = HashMap<Int,Int>()
    readLine()
    readLine().split(" ").forEach {
        if(map.contains(it.toInt())){
            map[it.toInt()] = map[it.toInt()]!! +1
        }
        else{
            map[it.toInt()] =1
        }
    }
    readLine()
    println(readLine().split(" ").map {
        map[it.toInt()]?: 0
    }.joinToString(" "))
}
