package programmers.greedy.uniform


const val MIN = -3333333
class Uniform {

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n-lost.size
        var lostArray: ArrayList<Int>  = ArrayList()
        var reserveArray: ArrayList<Int> = ArrayList()
        lost.forEach { lostArray.add(it) }.also { lostArray.sort() }
        reserve.forEach { reserveArray.add(it) }.also { reserveArray.sort() }

        lostArray.forEachIndexed { index, it ->
            if(reserveArray.contains(it)){
                reserveArray.remove(it)
                lostArray.set(index,MIN) //얘는 신경안씀 이제
                answer++
            }
        }//여분의 옷을 가지고있는것이랑 잃어버린 사람이랑 동일인물 일 때

        lostArray.forEach { it->
             if(reserveArray.contains(it-1)){
                reserveArray.remove(it-1);answer++ }

            else if(reserveArray.contains(it+1)){
                reserveArray.remove(it+1);answer++ }
        }

        return answer
    }
}

fun main() {
    val uniform = Uniform()
    val n = 5
    val lost = intArrayOf(2,4,5)
    val reserve = intArrayOf(1,3,4)
    println(uniform.solution(n,lost,reserve))
}