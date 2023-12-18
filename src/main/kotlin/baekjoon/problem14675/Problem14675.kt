package baekjoon.problem14675




fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    var treeList = Array(input+1) { EdgeList(arrayListOf()) }

    repeat(input-1){
        readLine().split(" ").map { it.toInt() }.also{
            treeList[it[0]].edge.add(it[1])
            treeList[it[1]].edge.add(it[0])
        }
    }


    repeat(readLine().toInt()){
        readLine().split(" ").map { it.toInt() }.also {
            if(it[0]==1){
                checkCutVertex(treeList,it[1])
            }
            else{
                println("yes")
            }
        }
    }

}

fun checkCutVertex(treeList:Array<EdgeList>,vertex:Int) : Unit=
    if(treeList[vertex].edge.size>=2) println("yes") else println("no")


data class EdgeList(var edge: java.util.ArrayList<Int>)