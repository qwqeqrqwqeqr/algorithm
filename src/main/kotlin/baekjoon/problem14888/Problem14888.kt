import baekjoon.problem21736.N
import java.util.*


val add: (Int, Int) -> Int = { x, y -> x + y }
val sub: (Int, Int) -> Int = { x, y -> x - y }
val mul: (Int, Int) -> Int = { x, y -> x * y }
val div: (Int, Int) -> Int = { x, y -> x / y }

var max: Int = Int.MIN_VALUE
var min: Int = Int.MAX_VALUE

val opList = arrayOf<(Int, Int) -> Int>(add, sub, mul, div)

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val opArray = IntArray(4)
    val array = IntArray(N)
    val visited = BooleanArray(N) { false }
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> array[index] = i }
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> opArray[index] = i }

    for (i in array.indices) {
        visited[i] = true
        backtracking(array[i], opArray, array, visited, N, 1)
        visited[i] = false
    }

    println(max)
    println(min)
}

fun backtracking(value: Int, opArray: IntArray, array: IntArray, visited: BooleanArray, N: Int, depth: Int) {
    if (depth == N) {
        max = Math.max(value, max)
        min = Math.min(value, min)
        return
    }
    for (i in array.indices) {
        if (!visited[i]) {
            visited[i] = true
            if(opArray[2]!=0 || opArray[3]!=0){
                for (j in 2 .. 3) {
                    if (opArray[j] > 0) {
                        opArray[j] = opArray[j] - 1
                        backtracking(opList[j](value, array[i]), opArray, array, visited, N, depth + 1)
                        opArray[j] = opArray[j] + 1
                    }
                }
            }
            else{
                for (j in 0 ..1) {
                    if (opArray[j] > 0) {
                        opArray[j] = opArray[j] - 1
                        backtracking(opList[j](value, array[i]), opArray, array, visited, N, depth + 1)
                        opArray[j] = opArray[j] + 1
                    }
                }
            }

            visited[i] = false
        }
    }
}

