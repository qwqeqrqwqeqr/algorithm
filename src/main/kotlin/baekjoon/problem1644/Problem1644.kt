package baekjoon.problem1644

val array = BooleanArray(4_000_001) { true }.also {
    it[0] = false
    it[1] = false
}


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val primeList = ArrayList<Int>()

    for (i in 0..4_000_000) {
        if (array[i]) {
            var j = i
            while (i.toLong() * j.toLong() <= 4_000_000L) {
                array[i * j] = false
                j += 1
            }
        }
    }
    array.forEachIndexed { index, b -> if (b) primeList.add(index) }

    var start = 0
    var end = 1
    var sum = primeList[start] + primeList[end]
    var answer = 0

    if(n==2) println(1)
    else {
        while (start <= end && end < primeList.size) {
            if (sum == n) {
                answer += 1
                sum -= primeList[start]
                start += 1
            } else if (sum < n) {
                end += 1
                if (end < primeList.size) {
                    sum += primeList[end]
                }
            } else {
                sum -= primeList[start]
                start += 1
            }
        }
        println(answer)
    }
}

/**
 * 3999971
 */