package baekjoon.problem15728

val arrayList = ArrayList<Card>()
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (N, K) = readLine().split(" ").map { it.toInt() }
    val shareCard = readLine().split(" ").map { it.toInt() }
    val teamCard = readLine().split(" ").map { it.toInt() }
    teamCard.forEachIndexed { teamCardIndex, team ->
        shareCard.forEach { share ->
            arrayList.add(Card(team * share, teamCardIndex))
        }
    }
    var tempList: List<Card> = arrayList.sortedWith(compareByDescending<Card> { it.value })
    repeat(K) { tempList = tempList.deleteCard() }
    println(tempList.first().value)
}

fun List<Card>.deleteCard(): List<Card> {
    val index = this.first().indexValue
    return this.filter { it.indexValue != index }
}

data class Card(val value: Int, val indexValue: Int)

//애리카드 N장의 공유숫자 N장 팀 숫자
//   K 장 견제



