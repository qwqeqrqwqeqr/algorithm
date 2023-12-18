package baekjoon.problem2304

import java.util.Stack
import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val barList: ArrayList<Bar> = arrayListOf()
    repeat(readLine().toInt()) {
        readLine().split(" ").map { it.toInt() }.apply {
            barList.add(Bar(this[0], this[1]))
        }
    }
    val (leftList, rightList) = barList.partition { it.position <= (barList.maxBy { it.height }?.position!!) }


    val left = calWidth(leftList.sorted())
    val right = calWidth( rightList.plus(barList.maxBy { it.height }).let { it.sortedByDescending { a -> a?.position } })

    println(left+right+ barList.filter { it.height == (barList.maxBy { it.height }!!.height) }.let {
        (abs(it.minBy { it.position }!!.position - it.maxBy { it.position }!!.position)+1) * it[0].height
    })
}

fun calWidth(list: List<Bar?>):Int{
    val stack : Stack<Bar> = Stack()
    list.forEach {
        if(stack.isEmpty()){ stack.add(it) }
        else{ stack.peek().also { item -> if(item.height< it!!.height){ stack.add(it) } } }
    }
    var value =0
    for(i in 1 until  stack.size){
        value += abs(stack[i].position - stack[i-1].position) * stack[i-1].height
    }
    return value
}


data class Bar(val position: Int, val height: Int) : Comparable<Bar> {
    override fun compareTo(other: Bar): Int = position - other.position
}


