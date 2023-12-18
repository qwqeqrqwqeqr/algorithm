package baekjoon.problem1062


import kotlin.math.max

var count = 0
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    var wordList: ArrayList<String> = arrayListOf()
    var tempList: ArrayList<String> = arrayListOf()
    val wordSet: MutableSet<Char> = HashSet()
    repeat(input[0]) {
        val string = readLine().toString()
        tempList.add(string)
    }
    if (input[1] < 5) {
        println(0)
        return@with
    }
    wordList.addAll(tempList.map { it.replace('a', ' ') }.map { it.replace('c', ' ') }.map { it.replace('i', ' ') }
        .map { it.replace('n', ' ') }.map { it.replace('t', ' ') }.map { it.replace(" ", "") }.toList())

    wordList.forEach { it.forEach { word -> wordSet.add(word) } }

    dfs(input[1] - 5, wordList, 0, wordSet)

    println(count)
}

fun dfs(K: Int, wordList: ArrayList<String>, index: Int, wordSet: MutableSet<Char>) {
    if (index == K) {
        var temp = 0
        wordList.forEach {
            if (it.checkZeroList()) {
                temp += 1
            }
        }
        count = max(count, temp)
        return
    }
    wordSet.forEach { word ->
        val list: ArrayList<String> = arrayListOf<String>().also { it.addAll(replaceWord(wordList, word)) }
        val set: MutableSet<Char> = HashSet<Char>()
        set.addAll(wordSet)
        set.remove(word)
        dfs(K, list, index + 1, set)
    }
    //시간초과 결국 못풀었고
}

fun String.checkZeroList(): Boolean {
    return this.isEmpty()
}

fun replaceWord(wordList: ArrayList<String>, word: Char): List<String> =
    wordList.map { string -> string.replace(word.toString(), "") }.toList()

