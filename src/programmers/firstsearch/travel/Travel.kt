package programmers.firstsearch.travel

import java.util.*
import kotlin.collections.ArrayList


class Travel {
    fun solution(tickets: Array<Array<String>>): ArrayList<String> {
        val ticket: ArrayList<Ticket> = ArrayList()
        var stack: Stack<String> = Stack()
        var answer:ArrayList<String> = ArrayList()
        tickets.forEach { ticket.add(Ticket(it[0], it[1])) }

        //모든 순열을 구해서 모든 경우의수에 대해서 판단함
        permutation(ticket.toList()).forEach  run@{
            println(it)
            stack.clear()
            //여행순서를 만들어내는 로직 만약 순서가 어긋날경우 continue 시킴
            it.forEach{
                if(stack.isEmpty()){stack.add(it.start); stack.add(it.destination)} else{
                    if (stack.pop() != it.start) {
                        stack.clear(); return@run
                    } else{ stack.add(it.start); stack.add(it.destination) }
                }
            }

            //대소를 비교하는 구문
            if(stack.isNotEmpty()){
                if(answer.isEmpty()){
                    stack.forEach { answer.add(it) }
                }
                else{
                    var string1:StringBuilder = java.lang.StringBuilder()
                    var string2:StringBuilder = java.lang.StringBuilder()
                    stack.forEach { string1.append(it) }
                    answer.forEach { string2.append(it) }
                    if(string1<string2){
                        answer.clear()
                        stack.forEach { answer.add(it) }
                    }
                }
            }
        }
        return answer
    }

    private fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> {
        return if (sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(el, fin + it, sub - it) }
    }
    data class Ticket(val start: String, val destination: String)
}

fun main() {
    val travel = Travel()
    val tickets = arrayOf(arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"), arrayOf("ATL", "ICN"), arrayOf("ATL","SFO"))
    println(travel.solution(tickets))
}
