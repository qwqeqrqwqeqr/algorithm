package baekjoon.problem20291

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val hashMap: HashMap<String,Int> = HashMap()
    repeat(readLine().toInt()){
         readLine().split(".").last().also {
            hashMap[it] = hashMap.getOrDefault(it,0) + 1
        }
    }
    hashMap.keys.sorted().forEach{ it ->
        bufferedWriter.append("${it} ${hashMap[it]}\n")
    }
    bufferedWriter.flush()
}

