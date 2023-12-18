package baekjoon.problem1581

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var (FF,FS,SF,SS) = readLine().split(" ").map { it.toInt() }
    println( find(FF,FS,SF,SS))
}

fun find(FF: Int, FS: Int, SF: Int, SS: Int): Int {
    if(FF==0 && FS ==0){ return SS+ Math.min(SF,1) }
    if(FS==0) {return  FF}
    if(FF==0){
        if(FS>SF){ return  (SF*2)+1+SS }
        else{ return (FS*2)+SS }
    }
    if(FS>SF){ return  FF + (SF*2)+1+SS }else{ return FF+(FS*2)+SS }
}

//FF FS SF SS
//1  2  1  1
//0  0  3  3

