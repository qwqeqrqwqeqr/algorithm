package baekjoon.problem3085


var max = Int.MIN_VALUE
var N = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    var array = Array(N) { CharArray(N) { 'A' } }

    repeat(N){ y ->
        readLine().toString().forEachIndexed { x, value -> array[y][x]  =value }
    }
    changeRow(array)
    changeColumn(array)
    println(max)
}

fun  changeRow(array: Array<CharArray>){
    for (i in 0 until N){
        for(j in 0 until  N-1){
            array[i][j] = array[i][j+1].also {   array[i][j+1] =   array[i][j]}
            findMax(array)
            array[i][j] = array[i][j+1].also {   array[i][j+1] =   array[i][j]}
        }
    }
}


fun  changeColumn(array: Array<CharArray>){
    for (j in 0 until N){
        for(i in 0 until  N-1){
            array[i][j] = array[i+1][j].also {   array[i+1][j] =   array[i][j]}
            findMax(array)
            array[i][j] = array[i+1][j].also {   array[i+1][j] =   array[i][j]}
        }
    }
}


fun findMax(array: Array<CharArray>){
    for(i in 0 until N){
        var count = 1
        for(j in 0 until  N-1){
            if(array[i][j]== array[i][j+1]){ count++ }
            else{
                count = 1
            }
            max = Math.max(count,max)
        }
    }
    for(j in 0 until  N){
        var count = 1
        for(i in 0 until  N-1){
            if(array[i][j]== array[i+1][j]){ count++ }
            else{
                count = 1
            }
            max = Math.max(count,max)
        }
    }
}

