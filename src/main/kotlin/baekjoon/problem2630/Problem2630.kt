package baekjoon.problem2630

var whiteCount = 0
var blueCount = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    var array = Array(N) { IntArray(N) { 0 } }



    repeat(N) { it ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            array[it][index] = i
        }
    }

    dfs(array)

    println(whiteCount)
    println(blueCount)
}

fun dfs(array: Array<IntArray>) {
    if (checkAllWhite(array)){
        whiteCount++
        return
    }
    if (checkAllBlue(array)) {
        blueCount++
        return
    }


    dfs(array.sliceArray(0 until array.size / 2).map {
        it.sliceArray(0 until array.size / 2)
    }.toTypedArray())
    dfs(array.sliceArray(0 until array.size / 2).map {
        it.sliceArray(array.size / 2 until array.size)
    }.toTypedArray())
    dfs(array.sliceArray(array.size / 2 until array.size).map {
        it.sliceArray(array.size / 2 until array.size)
    }.toTypedArray())
    dfs(array.sliceArray(array.size / 2 until array.size).map {
        it.sliceArray(0 until array.size / 2)
    }.toTypedArray())
}


fun checkAllWhite(array: Array<IntArray>): Boolean {
    array.forEach { ints ->
        ints.forEach { if (it == 1) return false }
    }
    return true
}

fun checkAllBlue(array: Array<IntArray>): Boolean {
    array.forEach { ints ->
        ints.forEach { if (it == 0) return false }
    }
    return true
}
