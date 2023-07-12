package baekjoon.problem2941



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    var input = readLine()
    val croatia = listOf<String>("dz=","c=","c-","d-","lj","nj","s=","z=")
    var count =0
    croatia.forEach {  c->
        while (c in input){
            input = input.replaceFirst(c,"+")
            count++
        }
    }
    input = input.replace("+","")
    println(count+input.length)
}


