package baekjoon.problem18511

/*
100000000 1
1

15 1
9

112 2
1 5

657 3
1 5 7

 */



import java.io.BufferedWriter
import java.io.OutputStreamWriter

var max = Int.MIN_VALUE
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ")
    val number = readLine().split(" ").map { it.toInt() }.toList()
    val target = input[0].toList().map { Character.getNumericValue(it) }.toMutableList()

    dfs(number,target,"",0)
    if(max== Int.MIN_VALUE){
        val maxNumber =number.sorted().last()
        max =  maxNumber.repeatAddData(target.size).toInt()
    }
    println(max)
}

fun Int.repeatAddData(times: Int): String {
    var temp = ""
    for(i in 0  until   times-1){
        temp += this.toString()
    }
    return temp
}
fun dfs(number:List<Int>,target:List<Int>,value:String, depth:Int){
    if(depth > target.size-1){
        if((value.toInt() <= target.joinToString("").toInt())){
            max = Math.max(value.toInt(),max)
            return
        }
    }
    else{
        number.forEach {
            dfs(number,target,value+it.toString(),depth+1)
        }
    }

}
