package programmers.heap.priorityqueue

import java.util.*


class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf(0, 0)
        val priorityMinQueue = PriorityQueue<Int>()  //최솟값
        val priorityMaxQueue = PriorityQueue<Int>(reverseOrder()) //최댓값

        operations.forEach {
            when (it[0]) {
                'I' -> {
                    priorityMaxQueue.add(it.substring(2, it.length).toInt())
                    priorityMinQueue.add(it.substring(2, it.length).toInt())
                }
                'D' -> {
                    if (it.substring(2, it.length).toInt() == 1) {
                        priorityMinQueue.remove(priorityMaxQueue.poll())  //Max 삭제후 Min 에 반영
                    } else if (it.substring(2, it.length).toInt() == -1) {
                        priorityMaxQueue.remove(priorityMinQueue.poll())  //Min 삭제후 Max 에 반영
                    }
                }
            }
        }

        /*정답 추출과정*/
        if (priorityMinQueue.isEmpty()) answer[1] = 0 else answer[1] = priorityMinQueue.peek()
        if (priorityMaxQueue.isEmpty()) answer[0] = 0 else answer[0] = priorityMaxQueue.peek()

        return answer
    }


}

fun main() {
    val solution = Solution()
    val array = arrayOf("\"I 16\",\"D 1")
    solution.solution(array).forEach {
        println(it)
    }
}