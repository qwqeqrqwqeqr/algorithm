package programmers.greedy.bignumber

import kotlin.math.max

class BigNumber3 {
    fun solution(number: String, k: Int): String {
        return find(number, k).toString()
    }

    fun find(number:String,k:Int):Int{
        var max=0
        if(k==0){ return number.toInt() }
        for(i in number.indices){
            max = max(max,find(number.removeRange(i,i+1),k-1))
        }
        return max
    }
}

fun main() {
    val bigNumber = BigNumber3()
    val number = "4177252841"
    val k = 4
    println(bigNumber.solution(number, k))
}