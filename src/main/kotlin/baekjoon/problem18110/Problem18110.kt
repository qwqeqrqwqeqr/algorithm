package baekjoon.problem18110

import kotlin.math.roundToInt
fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val levelList = ArrayList<Int>()
    readLine().toInt().apply {
        if(this==0){
            println(0)
        }else{
            repeat(this) {
                levelList.add(readLine().toInt())
            }
            println(levelList.sorted().drop((this.toFloat()/100 *15).roundToInt()).dropLast((this.toFloat()/100 *15).roundToInt()).average().roundToInt()
            )
        }
    }
}