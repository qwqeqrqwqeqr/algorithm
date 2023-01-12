package baekjoon.problem15721

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val A = readLine().trim().toInt()
    val T = readLine().trim().toInt()
    val flag = readLine().trim().toInt()
    val answer= when(flag){
        0 -> findFlagZero(findN(T),A,T)
        1 -> findFlagOne(findN(T),A,T)
        else -> {-1}
    }

    println(answer)


}

fun findFlagZero(n: Int, A: Int, T: Int) :Int{
    var current =T-findCount(n)
    var count = 0
    if(current<=2){
        count += (current*2)-1
    }else{
        count += 4 + current-2
    }
    val target = ((findTotal(n)+count)%A)-1
    if(target== -1){
        return A-1
    }
    else{
        return target
    }
}

fun findFlagOne(n: Int, A: Int, T: Int) :Int{
    var current =T-findCount(n)
    var count = 0
    if(current<=2){
        count = (current*2)
    }else{
        count = 4 + (n+1) + current-2
    }
    val target = (findTotal(n)+count)%A-1
    if(target== -1){
        return A-1
    }
    else{
        return target
    }
}
fun findTotal(n:Int): Int {
    var temp = 0
    for(i in 1 until n){
        temp+=4+((i+1)*2)
    }
    return temp
}
fun findCount(n:Int): Int {
    var temp = 0
    for(i in 1 until n){
        temp+=3+i
    }
    return temp
}

fun findN(T: Int): Int{
    var n=1
    var count =0
    while (true){
        count+=n+3
        if(T<=count){ break }
        n++
    }
    return n
}