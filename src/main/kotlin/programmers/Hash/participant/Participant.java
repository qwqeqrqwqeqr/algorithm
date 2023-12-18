package programmers.Hash.participant;

import java.util.HashMap;

public class Participant {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) {map.put(s,map.getOrDefault(s,0)+1);} //중복되는 값 있으면 ++
        for (String s : completion) {map.replace(s, map.get(s)-1);} // 중복되지않으면 --
        return map.entrySet().stream().filter(entry -> entry.getValue().equals(1)).findFirst().get().getKey(); //최종적으로 하나만남은거 찾기 나머지는 다 0이겠죠?
    }

    public static void main(String[] args) {
        Participant participant = new Participant();
        String[] participantPeople = {"m", "s", "m", "a"};
        String[] completionPeople = {"s", "a", "m"};
        System.out.println(participant.solution(participantPeople, completionPeople));
    }
}


