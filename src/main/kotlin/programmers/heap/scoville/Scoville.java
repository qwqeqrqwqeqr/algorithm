package programmers.heap.scoville;


import java.util.PriorityQueue;

public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int s: scoville) {priorityQueue.add(s);}

        while (priorityQueue.peek()<=K){
            if(priorityQueue.size()< 2) return -1; //K 이상으로 만들 수 없어지는 경우
            int first = priorityQueue.poll(); //첫번째
            int second = priorityQueue.poll(); //두번째
            int newScoville = first + (second*2); //로직수행
            priorityQueue.add(newScoville); //더하기
            answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        Scoville scoville = new Scoville();
        int[] array = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(scoville.solution(array, 7));
    }
}
