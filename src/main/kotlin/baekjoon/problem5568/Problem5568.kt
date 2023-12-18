package baekjoon.problem5568


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    val array= Array(n) { "" }
    val visited= BooleanArray(n){false}
    val answer = ArrayList<Int>()
    repeat(n){
        array[it] = readLine()
    }

    dfs(answer,visited,array,k,0,"0")

    println(answer.distinct().size)

}

fun dfs(answer:ArrayList<Int>,visited:BooleanArray,array:Array<String>, k:Int, depth:Int,value:String){
    if(k==depth){
        answer.add(value.toInt())
        return
    }

    for (i in 0 until array.size){
        if(!visited[i]){
            visited[i]= true
            dfs(answer,visited,array,k,depth+1,value+array[i])
            visited[i]= false
        }
    }
}
