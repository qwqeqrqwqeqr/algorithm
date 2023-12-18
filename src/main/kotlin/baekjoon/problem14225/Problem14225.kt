package baekjoon.problem14225

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val S = readLine().toInt()
    val list =  readLine().split(" ").map { it.toInt() }
    val visited =BooleanArray(list.sum()+1){false}

    dfs(list,0,visited,0)

    println(findFlag(visited))
}

fun findFlag(visited:BooleanArray): Int{
    for(i in 1 until visited.size){
        if(!visited[i]){ return i }
    }
    return visited.size
}

fun dfs(list:List<Int>,current:Int,visited: BooleanArray,value:Int) {
    if(current==list.size){
        visited[value]=true
        return
    }
    dfs(list,current+1,visited,value+list[current])
    dfs(list,current+1,visited,value)
}