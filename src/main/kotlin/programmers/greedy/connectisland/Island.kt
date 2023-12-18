package programmers.greedy.connectisland


import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.reflect.jvm.internal.impl.utils.DFS

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        val isLand = costs.sortedBy { it[2] }
        val visited: HashSet<Int> = HashSet<Int>().also { it.add(0) }
        var answer = 0
        while (visited.size < n) {
            for ((s, e, c) in isLand) {
                if (visited.contains(s) or visited.contains(e)) {
                    if (visited.contains(s) and visited.contains(e)) {
                        continue
                    }
                    visited.add(s)
                    visited.add(e)
                    answer += c
                    break
                }
            }
        }
        return answer
    }
    //1 2

    //3 4

    // 가장 낮은거 부터 섬을 채워나가고 (s,e)
    // 둘다 포함되어 있으면 얘는 이미 처리한 로직이니까 패스
    // 둘다 처리가 안되어있으면 추가하고 answer더함함
}
fun main() {
    var n: Int = 5
    var costs = Array(5) { IntArray(3) }
    costs[0] = intArrayOf(0, 1, 1)
    costs[1] = intArrayOf(2, 3, 1)
    costs[2] = intArrayOf(4, 5, 2)
    costs[3] = intArrayOf(1, 2, 2)
    costs[4] = intArrayOf(3, 4, 100)
    val island = Solution()
    System.out.println(island.solution(n, costs))
}


