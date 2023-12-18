package programmers.sort


class Solution1 {

    fun solution(numbers: IntArray): String {
        var answer = ""
        val zero = "0"
        val len = numbers.max().toString().length //자리수를 찾아냄
        val tempList = ArrayList<Int>()  // numbers List 추적
        val zeroList = ArrayList<String>()


        for (i in numbers.indices) {
            tempList.add(numbers[i])
        } //값 복사

        numbers.forEachIndexed() { index, item ->
            var tmp = ""
            for (i in 0 until len - item.toString().length) {
                tmp += zero
            }
            zeroList.add(tmp)
        }  //인덱스당 자리수 계산

        tempList.mapIndexed { index, item ->
            tempList[index] = (item.toString() + zeroList[index]).toInt()
        }//자리수 맞추기


        for (i in tempList.indices) {
            answer += numbers[tempList.indexOf(tempList.max()!!)]
            tempList[tempList.indexOf(tempList.max()!!)] = -1
        }

        return answer
    }
}


fun main() {
    val solution = Solution1()
    val intArray = intArrayOf(23, 5, 21, 332)
    println(solution.solution(intArray))
}