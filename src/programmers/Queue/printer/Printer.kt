package programmers.queue

import java.util.*


class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var location = location

        val arrayList: ArrayList<Int> = arrayListOf()
        priorities.forEach { arrayList.add(it) }

        var max =findMaxIndex(arrayList) //max 는 index임

        while (true) {
            if (max!=0) { //만약 max가 첫번째가 아니면 뒤로넘김
                arrayList.add(arrayList.first())
                arrayList.remove(arrayList.first())
            } else { //max가 첫번째 값이다
                answer++  //answer 더함
                if (location == 0) { break }  //근데 max랑 location이 똑같으면 마무리
                arrayList.remove(arrayList.first()) //max삭제
                max = findMaxIndex(arrayList) //다시 다음 max 찾아야함
                if (location == 0) {
                    location = arrayList.size - 1 } else {
                    location -= 1 } // index를 이동하는 명령어 (max갱신시켜줬기때문에 max는안함)
                continue
            }
            if (location == 0) {
                location = arrayList.size - 1 } else {
                location -= 1
            } // index를 이동하는 명령어
            if (max == 0){
                max = arrayList.size -1 }
            else{
                    max -= 1
            } // index를 이동하는 명령어

        }

        return answer
    }

    private fun findMaxIndex(arrayList: ArrayList<Int>): Int {
        var max = 0
        arrayList.forEachIndexed { index, it ->
            if (it > arrayList[max]) { max = index } }
        return max
    }//최댓값 구하기
}

fun main() {

    val intArray = intArrayOf(1,2,3)
    val location = 0

    val solution = Solution()
    println(solution.solution(intArray, location))
}