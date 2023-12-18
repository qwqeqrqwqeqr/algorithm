package baekjoon.problem1411

var answer =0
var N =0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arrayList = arrayListOf<String>()
    readLine().toInt().apply { N=this }
    repeat(N){
        arrayList.add(readLine().toString())
    }

    for(i in 0 until N){
        for(j in i+1 until N){
            if(validate(arrayList[i],arrayList[j])) answer++
        }
    }
    println(answer)
}

fun validate(source: String, target: String) :Boolean {
    if (source.length!=target.length) return false
    val map : HashMap<Char,Char> = hashMapOf()
    var numberValue = 'A'
    var transWord = target
    source.forEachIndexed { index, c ->
        if(!map.keys.contains(c)){
            map[c] = numberValue
            transWord=transWord.mapString(transWord[index], numberValue)
            numberValue+=1
        }
    }
   return transWord == source.map { map[it] }.joinToString("")
}
fun String.mapString(targetWord: Char, changeWord: Char) : String  = this.map { if(it==targetWord) changeWord else it }.joinToString("")

