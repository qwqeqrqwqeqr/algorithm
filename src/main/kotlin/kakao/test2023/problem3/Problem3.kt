package kakao.test2023.problem3

import kakao.test2023.B
import java.util.UUID

var max = Service(0, 0)
val discountRate = arrayOf(10,20,30,40)
class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val service = Service(0, 0)
        var count = 1
        val userList = mutableListOf<User>()
        users.forEach { userList.add(User(count++, it[0], it[1], 0)) }

        dfs(0, userList, emoticons, service)

        println(max)
        return answer.toIntArray()
    }
}

fun dfs(index: Int, users: MutableList<User>, emoticons: IntArray, service: Service) {
    if (index == emoticons.size) {
        if(max.member < service.member){
            println(service)
            users.forEach { println(it) }
            max = service
        }
        else if(max.member == service.member){
            if(max.total <= service.total){
                println(service)
                users.forEach { println(it) }
                max= service
            }
        }
    }else {
        for (i in 0..3) {
            val tempList = mutableListOf<Int>().also { it.clear() }
            users.forEach { tempList.add(it.total) }
            dfs(index + 1, users, emoticons, getService(discountRate[i], users, emoticons[index]))
            var count =0
            users.forEach { it.total = tempList[count++] }
        }
    }
}

fun getService(discount: Int, users: MutableList<User>, emoticon: Int): Service {
    val service = Service(0, 0)
    val price = (emoticon - emoticon * discount * 0.01).toInt()
    users.forEach {
        if (it.rate <= discount) {
            if (it.price <= price + it.total) {
                service.member += 1
                service.total += 5400
                service.total -= it.total
            } else {
                service.total += price
            }
            it.total+= price
        }
    }
    return service
}

fun main() {
    val solution: Solution = Solution()
    solution.solution(
        arrayOf(intArrayOf(40, 10000), intArrayOf(25, 10000)),
        intArrayOf(7000, 9000)
    ).forEach {
        println(it)
    }

}

data class User(val number: Int, val rate: Int, val price: Int, var total: Int)
data class Service(var member: Int, var total: Int)

