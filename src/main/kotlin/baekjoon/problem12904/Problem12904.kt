package baekjoon.problem12904


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val before = readLine()
    var after = readLine()


    while (true){
        if(after.length==before.length){ break }
        else{
            if(after.last()=='A'){
                after=after.dropLast(1)
            }
            else{
                after=after.dropLast(1)
                after=after.reversed()
            }
        }
    }
    if(after==before) println(1) else println(0)

}