package programmers.sort

class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var max=  0
        citations.forEach { if(max <= it) {max = it}}


        for(h_index in 1.. max){
            var low = 0
            var high = 0
            citations.forEach {
                    if(it >= h_index){ high++ }
                    else{ low++ }
            }
            if(h_index in low..high){ answer=h_index }
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    val array = intArrayOf(3,0,6,1,5)
    solution.solution(array)
}



