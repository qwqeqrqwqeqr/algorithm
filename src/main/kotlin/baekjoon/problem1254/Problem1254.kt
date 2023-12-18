package baekjoon.problem1254



var S = ""
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    S = readLine()
    var max = Int.MIN_VALUE

    for(i in S.indices){
        S.substring(i).let { if(it.findPalindrome()) { max = Math.max(max,it.length ) } }
    }
    println(max+(S.length-max)*2)
}
fun String.findPalindrome():Boolean{
    return if(this.length%2==0){
        (this.substring(0,(this.length/2))==this.substring(this.length/2,this.length).reversed())
    }
    else{
        (this.substring(0,(this.length/2)) == this.substring((this.length/2)+1,this.length).reversed())
    }
}