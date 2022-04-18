package programmers.Queue.dev_func


import kotlin.collections.ArrayList

class DevFunc {
    fun solution(progresses: IntArray, speeds: IntArray): ArrayList<Int> {
        var answer : ArrayList<Int> = arrayListOf()
        var index=0
        var indexTemp=0
        var count=0
        while(progresses[progresses.lastIndex]>=0) {  //isempty()
            count=0
            index=indexTemp
            for (i in index until progresses.size) {
                progresses[i] += speeds[i]
            }
            for(i in index until progresses.size){
                if(progresses[i]<100){
                    break
                } //첫번째부터 배포준비가 안되어있으면 로직을 건너뛴다.
                progresses[i] = Int.MIN_VALUE //처리완료
                count++  //처리완료 한 개수
                indexTemp++  //어디까지 처리했는가
            }
            if(count!=0) {
                answer.add(count)   //한번에 answer에 올려버림
            }
        }

        return answer
    }

}
fun main() {
    val devFunc = DevFunc();
    var progresses = intArrayOf(93,30,55)
    var speeds = intArrayOf(1,30,5)
    var answer : ArrayList<Int> = arrayListOf()
    answer=devFunc.solution(progresses,speeds)
    for (i in answer){
        print(i)
    }
}
