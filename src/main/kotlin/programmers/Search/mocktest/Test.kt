package programmers.search.mocktest



class Test {
    fun solution(answers: IntArray): ArrayList<Int> {

        var answer : ArrayList<Int> = ArrayList()
        var arrayList : ArrayList<Person> = ArrayList()
        arrayList.add(Person(p1,0,1))
        arrayList.add(Person(p2,0,2))
        arrayList.add(Person(p3,0,3))    //문제리스트, 맞춘횟수, 사람이름

        answers.forEachIndexed { answerIndex, answerValue ->
            arrayList.forEach{
                if(it.person[answerIndex%it.person.size]==answerValue){
                    it.count++ }
            }
        } //맞춘횟수 구하기
        val max =arrayList.sortedWith(compareBy(){it.count}).reversed().first().count  //가장 큰값 찾기

        arrayList.forEach {it -> if(max==it.count){ answer.add(it.name) }}  //점수가 동일한 사람들 전부 추출

        return answer
    }


    data class Person(var person: IntArray, var count: Int, var name :Int)
    var p1 = intArrayOf(1, 2, 3, 4, 5)
    var p2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    var p3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5)
}


fun main() {
    val test = Test()
    val numbers = intArrayOf(5, 5, 4, 2, 3)
    test.solution(numbers).forEach { println(it) }
}
