package programmers.graph.node

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        var route  = IntArray(n) { Int.MIN_VALUE }

//        edge.forEach {
//            if(it[0]==1)
//        }


        return answer
    }
}

fun main() {
    val solution = Solution()
    var n =6
    var vertex = arrayOf(intArrayOf(3,6), intArrayOf(4,3), intArrayOf(3,2), intArrayOf(1,3), intArrayOf(1,2), intArrayOf(2,4), intArrayOf(5,2))
    solution.solution(n,vertex)
}