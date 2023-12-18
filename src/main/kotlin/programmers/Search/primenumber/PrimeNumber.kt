package programmers.search.primenumber




class PrimeNumber {



    fun solution(numbers: String): Int {

        val hashSet: HashSet<Int> = HashSet()
        val arrayList= ArrayList<List<Char>>()
        powerset(numbers.toList()).forEach { it ->
            (permutation(it.toList()).forEach {
               arrayList.add(it)
           })
        } //모든 경우의 수 삽입
        arrayList.forEach { it ->
            var number = ""
            if(it.isEmpty()) {return@forEach}
            it.forEach { number+=it }
            hashSet.add(number.toInt())
        } //list를 숫자로 변환 set으로 중복제거
        hashSet.removeIf { !isPrime(it)} //소수만 출력
        return hashSet.size
    }









    private fun isPrime(n: Int): Boolean {
        var i = 2
        if(n==1||n==0) return false
        while (i * i <= n) {
            if (n % i++ == 0) return false
        }
        return true
    }// 소수인지 판단하는 함수


    private fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el): List<List<T>> {
        return if (sub.isEmpty()) listOf(fin)
        else sub.flatMap { permutation(el, fin + it, sub - it) }
    } //순열을 구하는 함수   123, 132 , 213 , 231 , 312 , 321


    private fun <T> powerset(s : List<T> ) : List<List<T>> = when {
        s.isEmpty() -> listOf(listOf())
        else -> {
            val head = s.first()
            val restSet = powerset(s.drop(1).toList())
            restSet + restSet.map{ listOf(head) + it}.toList()
        }
    } // 멱집합을 구하는 함수  ∮ ,1 ,2, 3, 12, 13, 23, 123


}

fun main() {
    val primeNumber = PrimeNumber()
    val numbers = "011"
    print(primeNumber.solution(numbers))
}

