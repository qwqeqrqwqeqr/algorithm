package programmers.hash.disguise



class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 0
        var hashMap : HashMap<String,String> = HashMap()
        clothes.forEach { hashMap[it[0]] = it[1] }
//        clothes.


        return answer
    }
}

fun main() {
    val solution = Solution()
    val array = arrayOf(arrayOf("yh","hg"), arrayOf("bs","ew"), arrayOf("gt","hg"))
    solution.solution(array)
}
