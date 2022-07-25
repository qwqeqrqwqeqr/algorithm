package baekjoon.problem1527

import java.util.*


//메모리 초과 //

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val min = nextInt().toLong()
    val max = nextInt().toLong()
    var answer =0
    var count =0

    for(i in min..max){
        count =0
        i.toString().forEach {
            if(it=='7'||it=='4'){
                count++ } }
        if(count==i.toString().length){
            answer++
        }
    }
    print("$answer")
}