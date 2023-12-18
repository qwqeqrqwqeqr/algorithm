package baekjoon.problem11866

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var N = nextInt()
    var K = nextInt() -1
    var head = 0
    var size = N
    var josephusArray: ArrayList<Int> = ArrayList<Int>()
    var arrayList: ArrayList<Int> = ArrayList()
    josephusArray.addAll(Array(N) { i -> i+1 })

    while(size>0) {
        head+=K
        head=checkIndexRangeOut(size, head)
        arrayList.add(josephusArray[head])
        josephusArray.removeAt(head)
        size= countDown(size)

    }
    printJosephusPermutation(arrayList)
}
fun countDown(count:Int) :Int = count-1

fun checkIndexRangeOut(size: Int, head: Int): Int {
    var currentHead = head
    while (size <= currentHead) {
        currentHead -= size
    }
    return currentHead
}

fun printJosephusPermutation(   josephusPermutation: ArrayList<Int>) {
    print(josephusPermutation.joinToString( prefix = "<", separator = ", ", postfix =  ">"))
}