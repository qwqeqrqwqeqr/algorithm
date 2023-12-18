package dynamicprogramming.presentationn

class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        var hashSet = HashSet<Int>()
        if(number == N) {return 1}
        hashSet.add(N)

        return answer
    }
}

// N은 1이상 9이하
// number는 1이상 32000이하
// N의 이전 상태를 가지고감
// 반복은  9까지
// 하나를 가지고 계속 빌드업 해나감


fun main() {
    val solution = Solution()
    val N = 5
    val number =12
    print(solution.solution(N,number))
}