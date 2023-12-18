package programmers.greedy.joystick




class JoyStick {
    fun solution(name: String): Int {
        var string: StringBuilder = java.lang.StringBuilder()
        var name = StringBuilder().also { it.append(name) } //AAAAAAA
        var cusor =0
        var count =0
        repeat(name.length){ string.append("A") }
        while (name.toString()!=string.toString()){
            var leftIndex = cusor
            var rightIndex = cusor

            while(name[leftIndex] == 'A' && name[rightIndex] == 'A'){
                leftIndex--; rightIndex++
                if(leftIndex == -1){ leftIndex = name.length-1 }
                if(rightIndex == name.length ){rightIndex= 0}
                count++
            }  //A가 아닌것을 만나면 바로 종료후 하나는왼쪽으로 하나는오른쪽으로 ㄱ감


            cusor =  if(name[rightIndex]!='A') rightIndex else leftIndex
            //그 인덱스까지 커서를 이동하고 이동 커서횟수 증가
            count += Replace(name[cusor])
            name[cusor] = 'A'
        }
        return count
    }
    fun Replace(char:Char):Int{  //알파벳을바꾸는커서
        if(char<='N'){ return  char-'A' }
        else{ return 'Z'-char+1 }
    }
    // BBBBAAAABA => 얘는 뒤부터 살펴보고 앞으로 오는게 더 횟수가 적은데 이거에 대한 로직을 어떻게 처리해야할지 모르겠음
}
fun main() {
    val joyStick = JoyStick()
    val name = "BBBBAAAABA"
    println(joyStick.solution(name))
}


//class JoyStick {
//    fun solution(name: String): Int {
//        // 최대로 이동해야하는 move
//        var move = name.length - 1
//        var answer = 0
//        for (i in name.indices) {
//            // 바꾸는 비용 더해준다
//            answer += min('Z' - name[i] + 1, name[i] - 'A')
//            // A를 만나면 양옆의 단어의 위치를 찾아준다
//            if (name[i] == 'A') {
//                var cursor = i
//                // 연속된 A가 있으면 cursor를 계속 이동
//                while (cursor < name.length && name[cursor] == 'A') {
//                    cursor++
//                }
//                val left = if (i - 1 < 0) 0 else i - 1
//                val right = if (cursor > name.length) 0 else cursor
//                // 앞으로 갔다가 뒤로가는 경우
//                move = min(move, 2 * left + name.length - right)
//                // 뒤로 갔다가 앞으로 가는경우
//                move = min(move, 2 * (name.length - right) + left)
//            }
//        }
//        return answer + move
//    }
//}

