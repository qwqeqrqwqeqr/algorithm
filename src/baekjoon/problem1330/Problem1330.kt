package baekjoon.problem1330

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var i =nextInt()
    var j =nextInt()
    if(i > j){
        println(">")
    }else if(i < j){
        println("<")
    }else{
        println("==")
    }
}
