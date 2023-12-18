package programmers.binarysearch.immigration

class Immigration {
    fun solution(n: Int, times: IntArray): Long {
        times.sort()
        val left =times.first().toLong()
        val right =(times.last()*n).toLong()
        return  search(left,right,(left+right)/2,n.toLong(),times)
    }

    fun search(left: Long, right:Long, mid:Long, n:Long,times: IntArray):Long{
        var target:Long =0
        times.forEach { target+=mid/it } //제한시간동안 최대한 검사받을 수 있는 사람
        if(target>=n){ //요구하는값 보다 크거나 같게 나올경우
            val right =mid-1
            if(left>right) return  mid   //양측의 기준이 무너질경우
            else if(left==right) return left //양축이 같아질경우  or right
            else { return search(left, right, (left + right)/2, n, times) }
        }else {//요구하는값 보다 작게나올경우
            return search(mid+1,right,(mid+1+right)/2,n,times) }
    }
}

fun main() {
    val immigration = Immigration()
    val n = 6
    val times= intArrayOf(7,10)
    println(immigration.solution(n,times))
}