package programmers.graph.ranking

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        var ranking = Array(n) { CharArray(n) }

        results.forEach { it ->
            ranking[it[0] - 1][it[1] - 1] = 'w'
            ranking[it[1] - 1][it[0] - 1] = 'l'
            println()
        }

        //A가 얘한테 이기면 나머지 A 한테 이긴 애들도 얘 이김
        //A가 얘 한테 지면  나머지 A 한테 진 애들도 얘 이김
        for (j in 0 until n) {
            for (i in 0 until n) {
                if (ranking[i][j] == 'w') {
                    for (k in 0 until n) {
                        if (ranking[j][k] == 'w') { ranking[i][k] = 'w' }
                    }
                }
                if (ranking[i][j] == 'l') {
                    for (k in 0 until  n){
                        if(ranking[j][k]=='l'){ ranking[i][k]='l' }
                    }
                }
            }
        }
        ranking.forEach {
            it.forEach { print(it) }
            println()
        }//출력용
        ranking.forEach {
            var count =0
            it.forEach { if(it=='w'||it=='l') count++ }
            if(count==n-1){
                answer++
            }
        }

        return answer
    }
}

fun main() {
    val solution = Solution()
    val n = 8
    val results = arrayOf(intArrayOf(1,2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(5, 6), intArrayOf(6,7),
        intArrayOf(7,8))
    print(solution.solution(n, results))
}