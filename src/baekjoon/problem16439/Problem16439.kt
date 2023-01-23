package baekjoon.problem16439

var max = Int.MIN_VALUE
var chicken = 0
var person = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    var chickenList = Array(input[0] + 1) { IntArray(input[1] + 1) { 0 } }
    var visited = BooleanArray(input[1] + 1) { false }
    repeat(input[0]) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            chickenList[it + 1][index + 1] = i
        }
    }
    chicken = input[1]
    person = input[0]
    dfs(chickenList, visited, 0, "", 1)
    println(max)
}

fun dfs(chickenList: Array<IntArray>, visited: BooleanArray, depth: Int, string: String, index: Int) {
    if (depth >= 3) {
        var tempSum = 0
        for (i in 1..person) {
            tempSum += chickenList[i][Character.getNumericValue(string[2])].coerceAtLeast(
                chickenList[i][Character.getNumericValue(string[0])].coerceAtLeast(
                    chickenList[i][Character.getNumericValue(string[1])]).coerceAtLeast(
                    Int.MIN_VALUE
                )
            )
        }
        println("$string  : $tempSum")
        max = tempSum.coerceAtLeast(max)
        return
    }
    for (i in index..chicken) {
        if (!visited[i]) {
            visited[i] = true
            dfs(chickenList, visited, depth + 1, string + i.toString(), i)
            visited[i] = false
        }
    }
}

/*

4 5
9 1 1 1 1
1 9 1 1 1
1 1 9 1 1
1 1 1 9 1

=> 28

4 3
0 0 0
0 0 0
0 0 0
0 0 0

=> 0

4 4
0 0 0 1
50 0 0 0
0 0 1 0
0 1 0 0

=> 52

1 5
10 20 30 40 50

=> 50
 */