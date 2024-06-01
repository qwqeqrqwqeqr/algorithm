package baekjoon.problem10820

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    while (true) {
        val string = readLine()
        if (string == null) break
        else {
            var a =0
            var b =0
            var c =0
            var d =0
            string.forEach {
                when(it){
                    in 'a' ..'z' -> ++a
                    in 'A'..'Z' -> ++b
                    in '0' .. '9' -> ++c
                    else -> ++d
                }
            }
            println("$a $b $c $d")
        }
    }
}