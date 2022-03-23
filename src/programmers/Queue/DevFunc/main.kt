package programmers.Queue.DevFunc

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