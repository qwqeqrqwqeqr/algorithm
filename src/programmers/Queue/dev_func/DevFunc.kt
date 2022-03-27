package programmers.Queue.dev_func


import kotlin.collections.ArrayList

class DevFunc {
    fun solution(progresses: IntArray, speeds: IntArray): ArrayList<Int> {
        var answer : ArrayList<Int> = arrayListOf()
        var index=0
        var indexTemp=0
        var count=0
        while(progresses[progresses.lastIndex]>=0) {
            count=0
            index=indexTemp
            for (i in index..progresses.size - 1) {
                progresses[i] += speeds[i]
            }
            for(i in index..progresses.size-1){
                if(progresses[i]<100){
                    break
                }
                progresses[i] = Int.MIN_VALUE
                count++
                indexTemp++
            }
            if(count!=0) {
                answer.add(count)
            }
        }

        return answer
    }

}

