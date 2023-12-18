
import java.io.BufferedWriter
import java.io.OutputStreamWriter
val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

var n = 0
var m = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N,M) = readLine().split(" ").map { it.toInt() }
    val array = IntArray(N) { 0 }
    val visited = BooleanArray(N){false}
    readLine().split(" ").map { it.toInt() }.sorted().forEachIndexed { index, i ->
        array[index]=i
    }
    m = M; n = N

    dfs(visited,array, arrayListOf(),0)
    bufferedWriter.flush()
}

fun dfs(visited: BooleanArray, array: IntArray, depth: ArrayList<Int>,index:Int) {
    if(depth.size>=m){
        bufferedWriter.append(depth.joinToString(" ")+"\n")
        return
    }
    for(i in index until n){
        if(!visited[i]){
            visited[i]=true
            depth.add(array[i])
            dfs(visited,array,depth,i)
            depth.remove(array[i])
            visited[i]=false
        }
    }
}