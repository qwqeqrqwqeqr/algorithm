package baekjoon.Problem2503

var count =0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val baseBallList = ArrayList<BaseBall>()
    val visited = BooleanArray(10){false}
    repeat(input) {
        readLine().split(" ").apply {
            baseBallList.add(BaseBall(this[0], this[1].toInt(), this[2].toInt()))
        }
    }
    dfs(0,baseBallList,visited,"")

    println(count)
}


fun dfs(depth:Int,baseBallList:ArrayList<BaseBall>,visited:BooleanArray,target: String){
    if(depth==3){
        var temp =0
        for(baseBall in baseBallList){
            if((checkBall(baseBall.baseBall,target)==baseBall.ball)&&
                (checkStrke(baseBall.baseBall,target)==baseBall.strike)){
                temp+=1
            }
        }
        if(temp==baseBallList.size){ count+=1 }
        return
    }
    for(i in 1 .. 9){
        if(!visited[i]){
            visited[i]=true
            dfs(depth+1,baseBallList,visited,target+i.toString())
            visited[i]=false
        }
    }
}

data class BaseBall(val baseBall: String, val strike: Int, val ball: Int)

fun checkBall(source: String, target: String): Int {
    var count = 0
    for (i in source.indices) {
        if (source.contains(target[i])&&target[i] != source[i]) {
            count += 1
        }
    }
    return count
}

fun checkStrke(source: String, target: String): Int {
    var count = 0
    for (i in source.indices) {
        if (target[i] == source[i]) {
            count += 1
        }
    }
    return count
}
