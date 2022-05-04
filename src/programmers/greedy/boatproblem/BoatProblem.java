package programmers.greedy.boatproblem;


import java.util.ArrayList;
import java.util.Collections;


public class BoatProblem {
    public int solution(int[] people, int limit) {
        ArrayList<Integer> arrayList = new ArrayList<>(); for (int a : people) {arrayList.add(a);}
        int answer = 0; int left = 0; int right = arrayList.size()-1; int count =0;
        Collections.sort(arrayList); //정렬

        while (right>=left) {
            if(arrayList.get(left) +arrayList.get(right)<=limit){
                left++; right--;answer++;}  //가장 큰 사람과 가장 작은사람이 매칭이되면 두사람을 보트에 실어보내고 인덱스를 경신함
            else{right--; count++;} //얘는 결국 따로가야함
        }  //남은 사람 중 가장 큰 것이 가장작은것 과도 매칭이 안된다는 것은 결국 전부 따로따로 가야함을 의미함 
        answer+=count; //따로가야하는애들 더해줌
        return answer;
    }
            // {10 10 20 20 70 80  80 80}
    public static void main(String[] args) {
        BoatProblem boatProblem = new BoatProblem();
        int[] people = {20 , 30,70,80, 90};
        int limit = 100;
        System.out.println(boatProblem.solution(people, limit));
    }
}
