package programmers.greedy.bignumber

import java.math.BigDecimal
import kotlin.math.max

//class BigNumber {
//    fun solution(number: String, k: Int): String {
//        var hashSet: HashSet<String> = HashSet()
//        find(number, k, hashSet)
//        return  hashSet.sortedWith(
//            Comparator<String> { a, b ->
//                when {
//                    a > b -> 1
//                    a < b -> -1
//                    else -> 0 } }).last()
//    }
//    fun find(number: String, k: Int, hashSet: HashSet<String>) {
//        if (k == 0) { hashSet.add(number) } else {
//            for (i in number.indices) { find(number.removeRange(i, i + 1), k - 1, hashSet) }
//        }
//    }
//}


class BigNumber {
    fun solution(number: String, k: Int): String {
        var hashSet: HashSet<String> = HashSet()
        find(number, k, hashSet)
        return  hashSet.sortedWith(
            Comparator<String> { a, b ->
                when {
                    a > b -> 1
                    a < b -> -1
                    else -> 0 } }).last()
    } //가장 큰거리 리턴
    fun find(number: String, k: Int, hashSet: HashSet<String>) {
        if (k == 0) { hashSet.add(number) } else {
            for (i in number.indices) { find(number.removeRange(i, i + 1), k - 1, hashSet) }
        }
    }//재귀로 모든경우의수 다뽑아내고



//    fun solution2(number: String,k: Int):String{
//        val length = number.length-k
//        var string = number
//        var tempCount =0
//        val answer = StringBuilder()
//        while(length>tempCount){
//            var tempIndex= 0
//            var max = 0
//            if(tempCount-length == string.length){
//                return answer.append(string).toString()
//            }
//            string.forEachIndexed { index, it ->
//                if(max< it.toInt()){
//                    max= it.toInt()
//                    tempIndex=index
//                }
//            }
//            tempCount++
//            answer.append(string[tempIndex])
//            string = string.drop(tempIndex+1)
//        }
//        return  answer.toString()
//    }
}

fun main() {
    val bigNumber = BigNumber()
    val number = "1231234"
    val k = 3234
    println(bigNumber.solution(number, k))
}