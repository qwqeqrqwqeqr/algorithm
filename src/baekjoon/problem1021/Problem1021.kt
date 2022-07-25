package baekjoon.problem1021

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    var left: Int;
    var right: Int
    var moveCount: Int =0
    var head: Int = 0
    val N = nextInt()
    val count = nextInt(); nextLine()
    val rotateQueue: ArrayList<Int> = ArrayList<Int>()
    rotateQueue.addAll(Array(N) { i -> i + 1 })
    val moveList: ArrayList<Int> = java.util.ArrayList()
    for (i in 1..count) {
        moveList.add(nextInt())
    }

    moveList.forEach {
        var targetIndex = rotateQueue.indexOf(it)
        if(rotateQueue.size==1){
            return@forEach
        }

        if (rotateQueue[head] == it) {
            rotateQueue.removeAt(head)
            return@forEach
        }

        if(head < targetIndex){
            left = (rotateQueue.size + head) - targetIndex
            right = targetIndex - head
        }
        else{
            left =  head- targetIndex
            right = (rotateQueue.size - head) + targetIndex
        }

        moveCount += if (left > right) right else left


        rotateQueue.removeAt(targetIndex)
        if(rotateQueue.size==targetIndex){
            head=0
        }else{
            head= targetIndex
        }


    }
    println(moveCount)
}
