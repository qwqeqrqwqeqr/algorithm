package kakao.test2023


class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val mutableListA :MutableList<A> = mutableListOf()
        val mutableListB :MutableList<B> = mutableListOf()
        val answerList = mutableListOf<Int>()
        var count = 1
        terms.map { it.split(" ").toList().let{ mutableListA.add(A(it[0],it[1].toInt())) } }
        privacies.map { it.split(" ").toList().let{ mutableListB.add(B(count++,it[0],it[1])) } }

        mutableListB.forEach {B->
            var date = Date(0,0,0)
            var todayDate: Date
            today.split(".").toList().let { todayDate = Date(it[0].toInt(),it[1].toInt(),it[2].toInt()) }
            mutableListA.forEach { A->
                if(A.type == B.type){
                    B.date.split(".").toList().let { date = Date(it[0].toInt(),it[1].toInt(),it[2].toInt()) }
                    date.month += A.expiredDate
                    date.day -= 1
                    date=transDate(date)
                }
            }
            if(checkExpiredDate(todayDate,date)){
                answerList.add(B.number)
            }
        }

        return answerList.toIntArray()
    }
}
data class A(val type:String, val expiredDate: Int)
data class B(val number:Int, val date : String, val type: String)
data class Date(var year:Int, var month: Int, var day: Int)

fun transDate(date:Date):Date{
    if(date.day==0){
        date.day = 28
        date.month-=1
    }
    while(date.month>12){
        date.month-=12
        date.year+=1
    }
    return date
}

fun checkExpiredDate( today:Date,  target: Date): Boolean{
    if(today.year<target.year){
        return false
    } else if(today.year==target.year){
        if(today.month<target.month){
            return false
        }
        else if(today.month==target.month){
            if(today.day<target.day){
                return false
            }
            else if(today.day==target.day){
                return false
            }
        }
    }
    return true
}

fun main(){
    val solution : Solution= Solution()
    solution.solution("2020.01.01", arrayOf<String>("Z 3", "D 5"), arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z") ).forEach {
        println(it)
    }

}

