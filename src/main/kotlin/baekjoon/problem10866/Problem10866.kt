package baekjoon.problem10866

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val deque: ArrayDeque<Int> = ArrayDeque()
    val bufferedWriter = System.out.bufferedWriter()
    repeat(readLine().toInt()) {
        val commend = readLine().split(" ")
        when (commend[0]) {
            "push_front" -> {
                deque.addFirst(commend[1].toInt())
            }

            "push_back" -> {
                deque.addLast(commend[1].toInt())
            }

            "pop_front" -> {
                deque.removeFirstOrNull()?.let { bufferedWriter.append("$it\n") } ?: bufferedWriter.append("-1\n")
            }

            "pop_back" -> {
                deque.removeLastOrNull()?.let { bufferedWriter.append("$it\n") } ?: bufferedWriter.append("-1\n")
            }

            "size" -> {
                bufferedWriter.append("${deque.size}\n")
            }

            "empty" -> {
                bufferedWriter.append("${(if (deque.isEmpty()) 1 else 0)}\n")
            }

            "front" -> {
                deque.firstOrNull()?.let { bufferedWriter.append("$it\n") } ?: bufferedWriter.append("-1\n")
            }
            "back" -> {
                deque.lastOrNull()?.let { bufferedWriter.append("$it\n") } ?: bufferedWriter.append("-1\n")
            }
        }
    }
    bufferedWriter.flush()
}