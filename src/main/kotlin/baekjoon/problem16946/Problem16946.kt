package baekjoon.problem16946

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

var N = 0
var M = 0
var dy = arrayOf(-1, 0, 1, 0)
val dx = arrayOf(0, 1, 0, -1)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }.apply {
        N = this[0]
        M = this[1]
    }
    val array = Array(n) { IntArray(m) }
    val answer = Array(n) { IntArray(m) }
    val stack: Stack<Pair<Int, Int>> = Stack()
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val visited = Array(n) { BooleanArray(m) }
    val map = HashMap<Int, Int>()
    var count = 2

    repeat(n) { r ->
        readLine().forEachIndexed { c, value ->
            array[r][c] = value.digitToInt()
            answer[r][c] = value.digitToInt()
            if (value.digitToInt() == 0) stack.add(r to c)
            if (value.digitToInt() == 1) queue.add(r to c)
        }
    }


    while (stack.isNotEmpty()) {
        val item = stack.pop()
        if (!visited[item.first][item.second]) {
            visited[item.first][item.second] = true

            if (array[item.first][item.second] > 1) {
                map[array[item.first][item.second]] = map[array[item.first][item.second]]!! + 1
            } else if (array[item.first][item.second] == 0) {
                array[item.first][item.second] = count
                map[count] = 1
                count += 1
            }

            for (i in 0..3) {
                val targetY = item.first + dy[i]
                val targetX = item.second + dx[i]
                if (checkBound(targetY, targetX) && array[targetY][targetX] == 0) {
                    array[targetY][targetX] = array[item.first][item.second]
                    stack.push(targetY to targetX)
                }
            }
        }
    }

    while (queue.isNotEmpty()) {
        val item = queue.poll()
        val set = HashSet<Int>()

        for (i in 0..3) {
            val targetY = item.first + dy[i]
            val targetX = item.second + dx[i]
            if (checkBound(targetY, targetX) && array[targetY][targetX] != 1) {
                set.add(array[targetY][targetX])
            }
        }
        answer[item.first][item.second] = (set.sumOf { key -> map[key]!! } +1 )%10
    }

    answer.forEach {
        println(it.joinToString(""))
    }
}


fun checkBound(y: Int, x: Int): Boolean {
    return (0 <= x && 0 <= y && y < N && x < M)
}

