package baekjoon.problem1012

import java.util.LinkedList
import java.util.Queue

val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var answer = arrayListOf<Int>()
    val T = readLine().toInt()

    for (k in 0 until T) {
        val input = readLine().split(" ").map { it.toInt() }
        val node: ArrayList<Pair<Int, Int>> = arrayListOf()
        val unionTotal: HashSet<HashSet<Pair<Int, Int>>> = hashSetOf<java.util.HashSet<Pair<Int, Int>>>(hashSetOf()).also { it.clear() }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        repeat(input[2]) {
            val coordinate = readLine().split(" ").map { it.toInt() }
            node.add(Pair(coordinate[0], coordinate[1]))
        }
        val visited = BooleanArray(input[2] + 1) { false }
        for (i in 0 until input[2]) {
            val union = hashSetOf<Pair<Int, Int>>()
            if (!visited[i]) {
                queue.add(Pair(node[i].first, node[i].second))
                union.add(Pair(node[i].first, node[i].second))
                visited[i] = true

                while (queue.isNotEmpty()) {
                    val temp = queue.poll()
                    for (j in 0 until 4)
                        if (node.indexOf(Pair(temp.first + dy[j], temp.second + dx[j])) != -1
                            && !visited[(node.indexOf(Pair(temp.first + dy[j], temp.second + dx[j])))]
                        ) {
                            queue.add(Pair(temp.first + dy[j], temp.second + dx[j]))
                            union.add(Pair(temp.first + dy[j], temp.second + dx[j]))
                            visited[(node.indexOf(Pair(temp.first + dy[j], temp.second + dx[j])))] = true
                        }
                }
                unionTotal.add(union)
            }
        }
       answer.add(unionTotal.size)
    }

    answer.forEach {
        println(it)
    }


}

