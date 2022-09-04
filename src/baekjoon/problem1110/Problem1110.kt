package baekjoon.problem1110


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()

    var oldNumber = N
    var newNumber = -1
    var count = 0

    while(newNumber!=N){
        val temp = oldNumber%10 + oldNumber/10
        if( temp<10){
           newNumber =  (oldNumber%10)*10 + temp
        }else{
            newNumber =  (oldNumber%10)*10 + temp%10
        }
        oldNumber=newNumber
        count++
    }
    println(count)
}