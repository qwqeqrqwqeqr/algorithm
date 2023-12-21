package baekjoon.problem7568


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val arrayList = ArrayList<HeightWeight>()
    repeat(readLine().toInt()) {
        readLine().split(" ").map { it.toInt() }.also { arrayList.add(HeightWeight(0, it[0], it[1])) }
    }

    arrayList.forEachIndexed { index1, heightWeight1 ->
        var count = 0
        arrayList.forEachIndexed { index2, heightWeight2 ->
            if (heightWeight1.height < heightWeight2.height && heightWeight1.weight < heightWeight2.weight)
                count += 1
        }
        arrayList[index1] = arrayList[index1].copy(count = count)
    }
    println(arrayList.map { it.count+1 }.joinToString(" "))
}


data class HeightWeight(val count: Int, val weight: Int, val height: Int)