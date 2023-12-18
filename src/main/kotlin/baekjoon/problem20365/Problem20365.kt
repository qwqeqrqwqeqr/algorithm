package baekjoon.problem20365

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val color = readLine().toList()
    var currentFlag = color[0]
    val newList = arrayListOf<Char>().also { it.add(color[0]) }

    color.forEach {
        if(currentFlag!=it){
            currentFlag=it
            newList.add(it)
        }
    }
   val min = Math.min(newList.count { it=='R' },newList.count { it=='B' })
    println(min+1)
}