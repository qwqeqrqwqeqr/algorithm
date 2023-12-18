package baekjoon.problem1107

import kotlin.math.abs


var high = Int.MIN_VALUE
var high_depth = 0
var low = Int.MAX_VALUE
var low_depth = 0
var N = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    var set = emptySet<Int>()
    if(readLine().toInt()!=0){ set=  readLine().split(" ").map { it.toInt() }.toHashSet() }
    val list = arrayListOf<Int>(0,1,2,3,4,5,6,7,8,9).subtract(set)
    dfs(list,"",0)
    if(high==Int.MIN_VALUE) high = Int.MAX_VALUE
    println(Math.min((Math.min(abs(N- high)+ high_depth, abs(N-low)+low_depth)), abs(N-100)  ))
}


fun dfs(list: Set<Int>, value:String,depth:Int){
    if(value.length>7){return}
    if(value!=""){
        if(value.toInt()<=N){
            if(high<value.toInt()){
                high=value.toInt()
                high_depth=depth
            }
        }
        if(value.toInt()>=N){
            if(low>value.toInt()){
                low=value.toInt()
                low_depth=depth
            }
        }
    }
    list.forEach {
        dfs(list,it.toString()+value,depth+1)
    }
}