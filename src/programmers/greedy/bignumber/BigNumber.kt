package programmers.greedy.bignumber

import java.math.BigDecimal
import kotlin.math.max

class BigNumber {
    fun solution(number: String, k: Int): String {
        var hashSet: HashSet<String> = HashSet()
        find(number, k, hashSet)
        return  hashSet.sortedWith(
            Comparator<String> { a, b ->
                when {
                    a > b -> 1
                    a < b -> -1
                    else -> 0 } }).last()
    }
    fun find(number: String, k: Int, hashSet: HashSet<String>) {
        if (k == 0) { hashSet.add(number) } else {
            for (i in number.indices) { find(number.removeRange(i, i + 1), k - 1, hashSet) }
        }
    }
}

fun main() {
    val bigNumber = BigNumber()
    val number = "4177252841"
    val k = 4
    println(bigNumber.solution(number, k))
}