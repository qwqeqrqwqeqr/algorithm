package baekjoon.problem5430



fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()
    val arrayList = ArrayDeque<AC>()
    repeat(input) {
        val function = readLine()
        val count = readLine().toInt()
        var list =  readLine().replace("[", "").replace("]", "").split(",").toMutableList()
        arrayList.add(
            AC(
                function, (if (count == 0) {
                    mutableListOf()
                } else list)
            )
        )
    }


    for (i in 0 until arrayList.size) {
        if (arrayList[i].function.count { it == 'D' } > arrayList[i].list.size) {
            println("error")
        } else {
            var R = 0
            arrayList[i].function.forEach {
                when (it) {
                    'D' -> {
                        if (R % 2 == 0) {
                            arrayList[i].list.removeFirst()
                        } else {
                            arrayList[i].list.removeLast()
                        }
                    }

                    'R' -> {
                        R += 1
                    }
                }
            }
            if (R % 2 != 0) {
                arrayList[i].list.reverse()
            }
            println(arrayList[i].list.toString().replace(" ", ""))
        }
    }

}


data class AC(var function: String, var list: MutableList<String>)