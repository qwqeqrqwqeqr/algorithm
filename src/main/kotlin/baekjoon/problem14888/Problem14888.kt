import java.util.*
import kotlin.collections.ArrayList


fun add(x: Int, y: Int): Int = x + y
fun sub(x: Int, y: Int): Int = x - y
fun mul(x: Int, y: Int): Int = x * y
fun div(x: Int, y: Int): Int = x / y

var max: Int = -1000000000
var min: Int = 100000000
val numberList = ArrayList<Int>()
val operatorList = ArrayList<Int>()
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt() //개수
    for (i in 0 until N) {
        numberList.add(nextInt())
    }
    nextLine()
    for (i in 0 until 4) {
        operatorList.add(nextInt())
    }
    dfs(1,numberList[0])
    println(max)
    println(min)
}


fun dfs(index: Int, current: Int) {
    if (index == numberList.size) {
        max = Math.max(max, current)
        min = Math.min(min, current)
    } else {
        for (i in 0..3)
            if (operatorList[i] > 0) {
                operatorList[i]--
                when (i) {
                    0 -> dfs(index + 1, add(current, numberList[index]))
                    1 -> dfs(index + 1, sub(current, numberList[index]))
                    2 -> dfs(index + 1, mul(current, numberList[index]))
                    3 -> dfs(index + 1, div(current, numberList[index]))
                }
                operatorList[i]++
            }
    }
}
