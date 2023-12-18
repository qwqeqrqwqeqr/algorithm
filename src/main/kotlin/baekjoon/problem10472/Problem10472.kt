package baekjoon.problem10472


import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
val dy = intArrayOf(-1, 0, 1, 0, 0)
val dx = intArrayOf(0, 1, 0, -1, 0)
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {

        val map = Array(3) { CharArray(3) { '1' } }
        repeat(3) { i ->
            readLine().forEachIndexed { j, value ->
                map[i][j] = value
            }
        }
        var mapQueue: Queue<Pair<Array<CharArray>,Array<BooleanArray>>> = LinkedList()
        mapQueue.add(Pair(map, Array(3) { BooleanArray(3) { false } }))
        bufferedWriter.append("${dfs(mapQueue)}\n")
    }

    bufferedWriter.flush()
}

fun dfs(mapQueue: Queue<Pair<Array<CharArray>,Array<BooleanArray>>>) :Int {
    var depth =0
    val tempQueue: Queue<Pair<Array<CharArray>,Array<BooleanArray>>> = LinkedList()
    while (mapQueue.isNotEmpty()){
        val map = mapQueue.poll()
        if (map.first.checkWhiteMap()) { return depth }
        var queue: Queue<Pair<Int, Int>> = LinkedList()
        queue = queue.fillQueue()
        while (queue.isNotEmpty()) {
            val item = queue.poll()
            if(!map.second[item.first][item.second]){
                map.second[item.first][item.second] = true
                tempQueue.add(Pair(convert(map.first,item),map.second))
                map.second[item.first][item.second] = false
            }
        }
        if(mapQueue.isEmpty()){
            mapQueue.addAll(tempQueue)
            depth+=1
        }
    }
    return -1
}

fun Queue<Pair<Int, Int>>.fillQueue(): Queue<Pair<Int, Int>> {
    for (i in 0..2) {
        for (j in 0..2) {
            this.add(Pair(i, j))
        }
    }
    return this
}

fun convert(map:Array<CharArray>, item: Pair<Int, Int>): Array<CharArray> {

    val temp = Array(3) { CharArray(3) { '1' } }
    for (i in map.indices) {
        temp[i] = map[i].copyOf(map[i].size)
    }

    for (i in 0..4) {
        if (checkBound(item.first + dy[i], item.second + dx[i])) {
            if (temp[item.first + dy[i]][item.second + dx[i]] == '.') temp[item.first + dy[i]][item.second + dx[i]] =
                '*' else temp[item.first + dy[i]][item.second + dx[i]] = '.'
        }
    }
    return temp
}

fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && x < 3 && y < 3)
}

fun Array<CharArray>.checkWhiteMap(): Boolean = (this.filter { 3 == it.count { it == '.' } }.size == 3)

//1
//*..
//**.
//*..