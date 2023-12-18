package baekjoon.problem1011

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()){
        readLine().split(" ").map { it.toInt() }.apply {
            bufferedWriter.append("${cal(this[1]-this[0])}\n")
        }
    }
    bufferedWriter.flush()

}

fun cal(distance: Int):Int{
    sqrt(distance.toDouble()).also {
        if(it%1 ==0.0){ return (it*2.0).toInt()-1}
        else {
            it.roundToInt().also {
                return if(distance> it.toDouble().pow(2.0)){
                    (it*2)
                }else{
                    (it*2)-1
                }
            }
        }

    }
}

//2
//1 5
//1 6
