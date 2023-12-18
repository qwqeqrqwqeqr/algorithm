package programmers.queue.truck

import java.util.*


class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        var temp = mutableListOf<Process>()
        var wait = mutableListOf<Process>()

        truck_weights.forEachIndexed { index, it ->
            temp.add(index,Process(it, 0))
        }// data class 매핑을함


        while (wait.isNotEmpty() || temp.isNotEmpty()) {  //진행리스트와 대기리스트가 전부 끝나면
            var waitingLimit = 0

            if(wait.isNotEmpty()){
                if(wait.first().time==bridge_length){
                    wait = wait.drop(1).toMutableList().also { wait = it }
                }
            } // 맨 앞에있는 트럭이 다리를 다 건넜으면 waitlist에서 삭제
            wait.forEach { waitingLimit = sum(it.weight, waitingLimit) } //다리안에있는 트럭의 무게 합을 전부더함
            if (temp.isNotEmpty()) {
                if (waitingLimit + temp.first().weight <= weight) { //새로 들어오려는 트럭이 무게제한에 안걸리면
                    wait.add(temp.first()) //대기하는 트럭  앞으로 보냄
                    temp = temp.drop(1).toMutableList().also { temp = it } //대기 하고있는트럭 앞으로보내ㅔㅁ
                }
            }

            wait.forEach { it.time += 1 } //진행하고 있는 트럭들 한타임씩 증가

            answer++
        }
        return answer
    }

    data class Process(var weight: Int, var time: Int)
    fun sum(a: Int, b: Int) = a + b
}


fun main() {
    val bridge_length = 100
    val weight = 100
    val truck_weights = intArrayOf(10,10,10,10,10,10,10,10,10,10)

    val solution = Solution()
    println(solution.solution(bridge_length, weight, truck_weights))
}