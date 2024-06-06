package baekjoon.problem9466


val visited = BooleanArray(100_001)
val finished = BooleanArray(100_001)
val array = IntArray(100_001)
var count = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        visited.fill(false)
        finished.fill(false)
        array.fill(0)
        count = 0
        readLine().split(" ").forEachIndexed { index, value ->
            array[index + 1] = value.toInt()
        }
        for (i in 1..n) {
            if (!visited[i]) dfs(i)
        }
        println(n-count)
    }
}


fun dfs(i: Int) {
    visited[i] = true
    var next = array[i]
    if(visited[next]){
        if(!finished[next]){
            count+=1
            while (i != next) {
                next = array[next];
                count+=1
            }
        }
    }else{
        dfs(array[i])
    }
    finished[i] = true
}
