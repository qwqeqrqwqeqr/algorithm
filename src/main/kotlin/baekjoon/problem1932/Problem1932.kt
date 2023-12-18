package baekjoon.problem1932

import kotlin.math.max

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var max = 0
    var inputList: ArrayList<ArrayList<Int>> = arrayListOf(arrayListOf())
    var sum: ArrayList<ArrayList<Int>> =arrayListOf(arrayListOf())
    repeat(N) {
        val temp= arrayListOf<Int>()
        temp.add(0)
        readLine().split(' ').map { it.toInt() }.forEach { temp.add(it) }
        inputList.add(temp as java.util.ArrayList<Int>)
    }

    sum.add(inputList[1])
    for (i in 2.. N ){
        val temp = arrayListOf<Int>().also { it.clear() }.also { it.add(0) }
        for(j in 1 .. i){
            if(j==1){ temp.add(sum[i-1][j]+inputList[i][j]) } //처음
            else if(i==j){temp.add(sum[i-1][j-1]+inputList[i][j])} //끝
            else{
                temp.add( inputList[i][j]+max(sum[i-1][j-1],sum[i-1][j]))
            }
        }
        sum.add(temp)
    }
    var answer =0
    sum.last().forEach {
        answer = max(answer,it)
    }
    println(answer)
}

// foreach => size 1번부터 나와요
