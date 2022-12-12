package baekjoon.problem5639


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val tree = Node(readLine().toInt(),null,null)

    while (true) {
        val input = readLine()
        if (input == "" || input == null) { break }
        insert(input.toInt(),tree)
    }

    postOrder(tree)

}
fun postOrder(tree:Node){
    tree.left?.let { postOrder(it) }
    tree.right?.let { postOrder(it) }
    println(tree.number)
}

fun insert(number:Int, tree:Node){
    if(tree.number >= number ){
        if(tree.left != null){
            insert(number, tree.left!!)
        }else{
            tree.left = Node(number,null,null)
        }
    }else{
        if(tree.right != null){
            insert(number, tree.right!!)
        }else{
            tree.right = Node(number,null,null)
        }
    }
}


data class Node(var number :Int =0, var left : Node?, var right: Node?)