package baekjoon.problem2980


import java.util.Scanner
import kotlin.math.abs


data class Light(val distance:Int , val red: Int, val green : Int)

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val count = nextInt()
    val distance = nextInt()
    var currentDistance =0
    var currentTime = 0
    var waitTime = 0
    val arrayList :  ArrayList<Light>  =java.util.ArrayList()
    for(i in 1..count) {
        arrayList.add(Light(nextInt(), nextInt(), nextInt()))
    }

    arrayList.forEach {
        currentDistance=it.distance
        currentTime = currentDistance + waitTime
        var temp = currentTime
        while(true){
            temp-=it.red
            if(temp<0){
                waitTime+=abs(temp)
                break
            }
            temp-=it.green
            if(temp<0){
                break
            }
        }
    }
    println(waitTime+distance)
}
