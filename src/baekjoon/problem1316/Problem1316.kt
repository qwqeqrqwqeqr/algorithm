package baekjoon.problem1316

var count =0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()){
        readLine().apply {
            if(WordList(this,arrayListOf(),this[0]).check()) count+=1
        }
    }
    println(count)
}


fun WordList.check():Boolean{
    this.word.forEach {
        if(!list.contains(it)){
            list.add(it)
        }
        else{
            if(it!=pre){ return false }
        }
        pre = it
    }
    return true
}


data class WordList(val word: String, val list : ArrayList<Char>, var pre: Char)