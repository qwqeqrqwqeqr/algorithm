package programmers.heap.disk

import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var priorityJobQueue = PriorityQueue<Process> { p1: Process, p2: Process -> p1.job - p2.job }
        var priorityTimeQueue = PriorityQueue<Process> { p1: Process, p2: Process -> p1.time - p2.time }
        jobs.forEach { priorityTimeQueue.add(Process(it[0], it[1])) }
        val size = priorityTimeQueue.size
        var progressTime = 0   //현재 진행중인 시간
        var waitTime = 0  //해당 프로세스가 대기하는 시간
        var currentTime = 0 //현재 프로세스가 처리 되는 시간 now , 현재 시간대에 있는 작업들을 전부 큐에 옮겨주기 위함
        var answer = 0

        while (priorityTimeQueue.isNotEmpty() || priorityJobQueue.isNotEmpty()) {

            while (priorityTimeQueue.isNotEmpty()) {
                if (priorityTimeQueue.peek().time <= progressTime || priorityJobQueue.isEmpty()) {
                    priorityJobQueue.add(priorityTimeQueue.poll().let {
                        currentTime=it.time
                        Process(it.time, it.job)
                    })
                } else if(priorityTimeQueue.peek().time== currentTime) {
                    priorityJobQueue.add(priorityTimeQueue.poll().let {
                        Process(it.time, it.job)
                    })
                }
                else{
                    break
                }
            }   //큐에 대기 작업들을 옮겨 주는작업 이때 같은시간대에 있는 작업과 이미 작업시간을 넘어간 작업들 불러옴
//            println(priorityJobQueue.size)
//            println("priorityJobQueue ${priorityJobQueue.peek()}")


            priorityJobQueue.poll().let {

                waitTime = if (progressTime - it.time > 0) progressTime - it.time else 0   //일이 시작되는 시간이 작업 누적시간보다  길면 얘는 그냥 대기 시간이 없는거나 다름없음
                progressTime += it.job     //작업이 진행 누적 시간
                answer += waitTime + it.job   //현재까지 대기하고 있는 시간, 이 작업이 진행되는 시간  


//                println("Process time  ${processTime}")
//                println("wait time  ${waitTime}")
//                println("answer time  ${answer}")
            }
        }
        return answer / size
    }

    data class Process(var time: Int, var job: Int)

}

fun main() {
    val solution = Solution()
//    val jobs = arrayOf(
//        intArrayOf(24,10),
//        intArrayOf(28,39),
//        intArrayOf(43,20),
//        intArrayOf(37,5),
//        intArrayOf(47,22),
//        intArrayOf(20,47),
//        intArrayOf(15,34),
//        intArrayOf(15,2),
//        intArrayOf(35,43),
//        intArrayOf(26,1),
//        )

//    val jobs = arrayOf(
//        intArrayOf(0, 3),
//        intArrayOf(1, 9),
//        intArrayOf(2, 6),
//        intArrayOf(30, 3),
//
//        )
//    val jobs = arrayOf(
//        intArrayOf(0, 3),
//        intArrayOf(4, 1)
//        )

    val jobs = arrayOf(
        intArrayOf(0, 3),
        intArrayOf(4, 1),
        intArrayOf(500,3)
    )

//    val jobs = arrayOf(
//        intArrayOf(0, 10),
//        intArrayOf(4, 10),
//        intArrayOf(15, 2),
//        intArrayOf(5, 11)
//        )

    println(solution.solution(jobs))

}