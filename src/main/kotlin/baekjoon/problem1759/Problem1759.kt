package baekjoon.problem1759


val vowelIndex = arrayListOf<Char>('a','e','i','o','u')
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {

    val input = readLine().split(" ").map { it.toInt() }
    val password = readLine().split(" ").map { it.toCharArray()[0]}.toList()

    val answer = arrayListOf<Char>()
    findPassword(answer,password.sorted(),0,input[0])

}

fun findPassword(answer: ArrayList<Char>, password: List<Char>, depth: Int, maxIndex: Int) {
    if(maxIndex==answer.size){
        if(checkCondition(answer)){
            answer.forEach { print("$it") }.also { println() }
            return
        }
    }
    if(password.size == depth){ return }

    answer.add(password[depth])
    findPassword(answer,password,depth+1,maxIndex)
    answer.removeLast()
    findPassword(answer,password,depth+1,maxIndex)
}

fun checkCondition(answer: ArrayList<Char>): Boolean {
    var vowelCount =0
    var consonantCount =0
    answer.forEach {
        if(vowelIndex.contains(it)){ vowelCount++ }
        else{ consonantCount++ }
    }

    return vowelCount>=1&&consonantCount>=2
}



