package baekjoon.problem1138

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val array = IntArray(N) { -1 }
    readLine().split(" ").mapIndexed { index, it ->
        var count = 0
        for (i in array.indices) {
            if (count == it.toInt() && array[i] == -1) {
                array[i] = index+1
                break
            }
            if (array[i] == -1) count += 1
        }
    }

    println(array.joinToString(" "))
}


/**
 * 줄을 선대로 키순
 *
 * 1왼쪽 2명    무조건 3번자리
 * 2왼 1명  1번아님 2번자리    첫번째보다 작으면 무조건 왼쪽
 * 3왼 1명
 * 4왼 0명
 */