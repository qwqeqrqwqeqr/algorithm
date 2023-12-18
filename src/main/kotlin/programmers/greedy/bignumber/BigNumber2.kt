package programmers.greedy.bignumber

import kotlin.math.max

class BigNumber2 {
    fun solution(number: String, k: Int): String {
        var arrayList : ArrayList<Int> = ArrayList()
        permutation(number.toList()).forEach {
            var temp = ""
            for(i in 0 until  it.size-k){ temp += it[i] }
            arrayList.add(temp.toInt())
        }
        var max = arrayList.get(0)
        arrayList.forEach { max = max(it,max) }
        return max.toString()
    }

    private fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> {
        return if (sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(el, fin + it, sub - it) }
    }
}
fun main() {
    val bigNumber2 = BigNumber2()
    val number = "1231234"
    val k = 3
    println(bigNumber2.solution(number,k))
}