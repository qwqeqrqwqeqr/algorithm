package baekjoon.problem10989

import java.io.BufferedWriter
import java.io.OutputStreamWriter


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val intArray = IntArray(10_001) { 0 }
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) { intArray[readLine().toInt()] += 1 }
    intArray.forEachIndexed { index, i ->
       if(i!=0) repeat(i){ bufferedWriter.append("${index}\n") }
    }
    bufferedWriter.flush()
}