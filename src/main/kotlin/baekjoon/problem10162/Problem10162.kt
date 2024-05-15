package baekjoon.problem10162

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var input = readLine().toInt()
    var a = input / 300
    input%=300
    var b = input / 60
    input%=60
    var c = input / 10
    input%=10

    if(input!=0) println(-1) else println("$a $b $c")
}