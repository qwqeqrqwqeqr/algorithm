package baekjoon.problem7662

import java.util.*
import kotlin.collections.HashMap

const val EMPTY = "EMPTY"
fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val priorityQueue: PriorityQueue<Int> = PriorityQueue()
        val reversePriorityQueue: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        val hashMap: HashMap<Int, Int> = HashMap()
        repeat(readLine().toInt()) {
            val input: Pair<Char, Int> = readLine().split(" ").let { it[0].toCharArray()[0] to it[1].toInt() }
            when (input.first) {
                'I' -> add(priorityQueue, reversePriorityQueue, hashMap, input.second)
                else -> {
                    if (input.second == 1) delete(reversePriorityQueue, hashMap)
                    else delete(priorityQueue, hashMap)
                }
            }
        }

        print(hashMap)
    }
}

fun print(hashMap: HashMap<Int, Int>) {
    println(if (hashMap.isEmpty()) EMPTY else "${hashMap.maxOf { it.key }} ${hashMap.minOf { it.key }}")
}

fun add(
    priorityQueue: PriorityQueue<Int>,
    reversePriorityQueue: PriorityQueue<Int>,
    hashMap: HashMap<Int, Int>,
    item: Int
) {
    priorityQueue.add(item)
    reversePriorityQueue.add(item)
    hashMap[item] = hashMap.getOrDefault(item, 0) + 1
}

fun delete(priorityQueue: PriorityQueue<Int>, hashMap: HashMap<Int, Int>) {
    while (true) {
        if (priorityQueue.isEmpty()) break
        val item = priorityQueue.poll()
        val count = hashMap.getOrDefault(item, 0)
        if (count == 1) {
            hashMap.remove(item)
            break
        } else if (count > 1) {
            hashMap[item] = count - 1
            break
        }
    }
}
