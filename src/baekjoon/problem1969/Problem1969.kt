package baekjoon.problem1969


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    val arrayList = ArrayList<String>()
    var answerCode = ""
    var answerCount = 0
    repeat(input[0]) {
        arrayList.add(readLine())
    }

    for (i in 0 until input[1]) {
        var codeList = ArrayList<Code>().also {
            it.add(Code('T', 0))
            it.add(Code('C', 0))
            it.add(Code('G', 0))
            it.add(Code('A', 0))
        }
        arrayList.forEach { it ->
            when (it[i]) {
                'T' -> codeList[0].count++
                'C' -> codeList[1].count++
                'G' -> codeList[2].count++
                'A' -> codeList[3].count++
            }
        }
        codeList.sortWith(compareByDescending<Code>{ it.count }.thenBy { it.name })

        codeList.first().apply {
            answerCode+=name
            answerCount+= input[0] - count
        }
    }
    println(answerCode)
    println(answerCount)

}
data class Code(var name: Char, var count: Int)