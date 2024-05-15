package baekjoon.problem5622

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val hashMap = HashMap<Char, Int>()
    hashMap['A'] = 3
    hashMap['B'] = 3
    hashMap['C'] = 3
    hashMap['D'] = 4
    hashMap['E'] = 4
    hashMap['F'] = 4
    hashMap['G'] = 5
    hashMap['H'] = 5
    hashMap['I'] = 5
    hashMap['J'] = 6
    hashMap['K'] = 6
    hashMap['L'] = 6
    hashMap['M'] = 7
    hashMap['N'] = 7
    hashMap['O'] = 7
    hashMap['P'] = 8
    hashMap['Q'] = 8
    hashMap['R'] = 8
    hashMap['S'] = 8
    hashMap['T'] = 9
    hashMap['U'] = 9
    hashMap['V'] = 9
    hashMap['W'] = 10
    hashMap['X'] = 10
    hashMap['Y'] = 10
    hashMap['Z'] = 10
    println(readLine().map { hashMap[it]!! }.sum())
}