package baekjoon.problem10815


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine()
    val map = HashMap<Int,Boolean>()
    readLine().split(" ").map { map.put(it.toInt(),true)  }
    readLine()
    println(readLine().split(" ").map {  if(map[it.toInt()]==true) 1 else 0  }.joinToString(" "))
}