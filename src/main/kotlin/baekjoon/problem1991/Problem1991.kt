package baekjoon.problem1991



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val parentList: Array<Child> = Array(input+1){Child()}

    repeat(input){
        readLine().split(" ").map { it.toCharArray() }. let {
            parentList[it[0][0] - 'A'].left = it[1][0] -'A'
            parentList[it[0][0] - 'A'].right = it[2][0] -'A'
        }
    }

    preOrder(0,parentList)
    println()

    inOrder(0,parentList)
    println()

    postOrder(0,parentList)
    println()


}

fun preOrder(root: Int,parentList:Array<Child> ) {
    val left: Int = parentList[root].left
    val right: Int = parentList[root].right
    print((root + 'A'.toInt()).toChar())
    if (left > 0) preOrder(left,parentList)
    if (right > 0) preOrder(right,parentList)
}

fun inOrder(root: Int,parentList:Array<Child> ) {
    val left: Int = parentList[root].left
    val right: Int = parentList[root].right
    if (left > 0) inOrder(left,parentList)
    print((root + 'A'.toInt()).toChar())

    if (right > 0) inOrder(right,parentList)
}

fun postOrder(root: Int,parentList:Array<Child> ) {
    val left: Int = parentList[root].left
    val right: Int = parentList[root].right
    if (left > 0) postOrder(left,parentList)
    if (right > 0) postOrder(right,parentList)
    print((root + 'A'.toInt()).toChar())

}

data class Child(var left : Int = -1, var right:Int = -1)




